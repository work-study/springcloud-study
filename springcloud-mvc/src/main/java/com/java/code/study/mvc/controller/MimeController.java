package com.java.code.study.mvc.controller;

import com.java.code.study.mvc.model.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zouw
 * @date Created in 1:27 PM 2019/4/19
 */
@RestController
@EnableWebMvc
public class MimeController {
    @RequestMapping(value = "/mime/testHttp",method = RequestMethod.GET)
    public String testHttp() {
        return "OK";
    }

    @RequestMapping(value = "/mime/testJson",method = RequestMethod.POST)
    public Person testJson(@RequestBody Person person) {
        return person;
    }
}
