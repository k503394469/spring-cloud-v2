package com.liu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启用EurekaServer
@EnableEurekaServer
@SpringBootApplication
public class Eureka2App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka2App.class, args);
    }
}
