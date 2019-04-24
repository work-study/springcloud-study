package com.java.code.study.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import rule.MyselfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-REST-PROVIDER-8001",configuration = MyselfRule.class)
public class SpringcloudRestConsumer8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRestConsumer8002Application.class, args);
    }

}
