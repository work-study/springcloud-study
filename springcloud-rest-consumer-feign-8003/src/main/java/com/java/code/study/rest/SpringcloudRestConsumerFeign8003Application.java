package com.java.code.study.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = "com.java.code.study.rest")
public class SpringcloudRestConsumerFeign8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRestConsumerFeign8003Application.class, args);
    }

}
