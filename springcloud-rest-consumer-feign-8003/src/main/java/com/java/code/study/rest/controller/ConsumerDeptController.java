package com.java.code.study.rest.controller;


import com.java.code.study.rest.entity.Dept;
import com.java.code.study.rest.service.DeptService;
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
    private DeptService deptService;

    @RequestMapping(value = "/c/addDept",method = RequestMethod.POST)
    public Integer addDept(@RequestBody Dept dept) {
        Integer result = deptService.addDept(dept);
        System.out.println("result"+result);
        return result;
    }
}
