package com.gao.eurekaclientdockerb;

import com.gao.eurekaclientdockerb.vo.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RestController
@EnableAsync
@RefreshScope
public class EurekaclientdockerbApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientdockerbApplication.class, args);
    }

    @Value("${project}")
    String project;

    @RequestMapping(value = "/getConf",method = RequestMethod.GET)
    public String getConf() {
        return project;
    }

    @RequestMapping(value = "/getHost",method = RequestMethod.GET)
    public String getHost() {
        String hostIP = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String host = ia.getHostName();//获取计算机主机名
            String ip = ia.getHostAddress();//获取计算机IP
            hostIP = host + "-" + ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostIP;
    }

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam String name) {
        return "hi "+name+",i am from port:"/* +port*/;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @RequestMapping("/hiObj")
    @HystrixCommand(fallbackMethod = "hiObjError")
    // 此处注意 如果打断点 则会人为断路 走断路器方法
    public Person hiObj(@RequestBody Person p) {
        return new Person(p.getAge()+1,p.getName()+"n");
    }

    public Person hiObjError(@RequestBody Person p) {
        return new Person(20,"error");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    // Use this for debugging (or if there is no Zipkin server running on port 9411)
//    @Bean
//    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
//    public Reporter<Span> spanReporter() {
//        return Reporter.CONSOLE;
//    }
}
