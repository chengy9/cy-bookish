package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.example.mapper")
@EnableEurekaClient
public class MainApplication8002 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication8002.class, args);
    }
}
