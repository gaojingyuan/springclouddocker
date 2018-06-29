package com.gao.configserverdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverdockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigserverdockerApplication.class, args);
    }
}
