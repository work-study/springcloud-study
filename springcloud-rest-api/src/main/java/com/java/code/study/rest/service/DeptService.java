package com.java.code.study.rest.service;

import com.java.code.study.rest.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zouw
 * @date Created in 5:56 PM 2019/4/20
 */
@FeignClient(value = "SPRINGCLOUD-REST-PROVIDER-8001")
public interface DeptService {

    @RequestMapping(value = "/dept/addDept", method = RequestMethod.POST)
    Integer addDept(Dept dept);
}
