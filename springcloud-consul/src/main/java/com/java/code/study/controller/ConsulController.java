package com.java.code.study.controller;

import com.orbitz.consul.model.health.ServiceHealth;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zouw
 * @date Created in 7:52 PM 2019/4/4
 */

@RestController
public class ConsulController {

    /*******************************服务注册与发现*******************************/
    @RequestMapping(value="/registerService",method=RequestMethod.GET)
    public String registerService() {
        System.out.println("aadasdfsafsf");
        return "OK";
    }
}