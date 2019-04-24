package com.java.code.study.rest.controller;


import com.java.code.study.rest.entity.Dept;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zouw
 * @date Created in 5:20 PM 2019/4/20
 */
@RestController
public class DeptController {

    @Resource
    private DiscoveryClient client;
    @RequestMapping(value = "/dept/getDept",method = RequestMethod.GET)
    public Dept getDept(@RequestParam("id") Long id) {
        System.out.println("id:"+id);
        return new Dept().setDname("zzzz");
    }

    @RequestMapping(value = "/dept/addDept",method = RequestMethod.POST)
    public Integer addDept(@RequestBody Dept dept) {
        System.out.println("dept:"+dept);
        return 1;
    }

    @RequestMapping(value = "/dept/getServerList",method = RequestMethod.GET)
    public List<String> getServerList() {
        List<String> services = client.getServices();
        return services;
    }
}
