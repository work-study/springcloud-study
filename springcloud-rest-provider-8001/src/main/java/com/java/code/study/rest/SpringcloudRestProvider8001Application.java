package com.java.code.study.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringcloudRestProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRestProvider8001Application.class, args);
    }

}
