package com.gao.eurekaserverdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverdockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverdockerApplication.class, args);
	}
}
