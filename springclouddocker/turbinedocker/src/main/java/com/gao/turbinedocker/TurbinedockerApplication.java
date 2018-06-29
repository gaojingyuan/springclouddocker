package com.gao.turbinedocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbinedockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbinedockerApplication.class, args);
    }
}
