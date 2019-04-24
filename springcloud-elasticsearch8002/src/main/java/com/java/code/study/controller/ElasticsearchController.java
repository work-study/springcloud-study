package com.java.code.study.controller;

import com.java.code.study.config.RestClientConfig;
import com.java.code.study.service.EsBasicService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zouw
 * @date Created in 10:36 AM 2019/4/10
 */
@RestController
public class ElasticsearchController {

    @Resource
    private RestClientConfig restClientConfig;

    @Resource
    private EsBasicService esBasicService;

    @RequestMapping(value = "/es/getRestClientConfig",method = RequestMethod.GET)
    public String getRestClientConfig() {
        System.out.println(restClientConfig.getClusterName());
        System.out.println(restClientConfig.getClusterNodes());
        System.out.println(restClientConfig.getScheme());
        System.out.println(restClientConfig.getRestClient());
        return "OK";
    }

    @RequestMapping(value = "/es/addDataToES",method = RequestMethod.GET)
    public String addDataToES() throws IOException {
        String index="user";
        String type = "customer";
        String data="{\"name\": \"zw2\",\"age\": \"19\"}";
        return esBasicService.performPut(index,type,"2",data);
    }
    @RequestMapping(value = "/es/queryData",method = RequestMethod.GET)
    public String queryData(@RequestBody String query) throws IOException {
        String index="user";
        String type = "customer";
        //query="{\"query\":{\"match_all\":{}}}";
        return esBasicService.performGet(index,type,query);
    }
}
