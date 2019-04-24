package com.java.code.study.rest.controller;


import com.java.code.study.rest.entity.Dept;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zouw
 * @date Created in 5:20 PM 2019/4/20
 */
@RestController
public class ConsumerDeptController {

    @Resource
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-REST-PROVIDER-8001";

    @RequestMapping(value = "/c/getDept",method = RequestMethod.GET)
    public Dept getDept(@RequestParam("id") Long id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        Dept forObject = restTemplate.getForObject(REST_URL_PREFIX + "/dept/getDept", Dept.class, map);
        System.out.println(""+forObject);
        return forObject;
    }

    @RequestMapping(value = "/c/addDept",method = RequestMethod.POST)
    public Integer addDept(@RequestBody Dept dept) {
        Integer result = restTemplate.postForObject(REST_URL_PREFIX + "/dept/addDept", dept,Integer.class);
        System.out.println("result"+result);
        return result;
    }
}
