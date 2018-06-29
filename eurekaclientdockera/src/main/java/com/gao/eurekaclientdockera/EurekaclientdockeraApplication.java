package com.gao.eurekaclientdockera;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class EurekaclientdockeraApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientdockeraApplication.class, args);
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
