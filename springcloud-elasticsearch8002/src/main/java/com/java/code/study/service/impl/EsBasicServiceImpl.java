package com.java.code.study.service.impl;


import java.io.IOException;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.study.config.RestClientConfig;
import com.java.code.study.entity.result.GetResult;
import com.java.code.study.service.EsBasicService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;


/**
 * @author zouw
 * @date Created in 10:56 AM 2019/4/10
 */
@Component
public class EsBasicServiceImpl implements EsBasicService {
    private static final String PUT = "PUT";
    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String HEAD = "HEAD";
    private static final String DELETE = "DELETE";
    private RestClient rsc;

    @PostConstruct
    public void init() {
        System.out.println("初始化restClient..");
        rsc = restClientConfig.getRestClient();
        System.out.println("初始化restClient完成..");
        System.out.println(rsc.hashCode());
    }

    @Resource
    private RestClientConfig restClientConfig;

    private ObjectMapper om = new ObjectMapper();


    @Override
    public String performGet(String index, String type, String query) throws IOException {
        HttpEntity entity = new NStringEntity(query, ContentType.APPLICATION_JSON);
        String endpoint = "/" + index + "/" + type + "/_search";
        if (StringUtils.isBlank(type)) {
            endpoint = "/" + index + "/_search";
        }
        Request request = new Request(GET,endpoint);
        request.addParameter("pretty","true");
        request.setEntity(entity);
        GetResult responseResult = new GetResult();
        Response response = rsc.performRequest(request);
        String result = EntityUtils.toString(response.getEntity());
        if (StringUtils.isNotBlank(result)) {
            responseResult = om.readValue(result, GetResult.class);
        }
        List<Map<String, Object>> sourceByResult= new ArrayList<>();
        if (responseResult != null) {
            sourceByResult = responseResult.getSourceByResult();
        }
        System.out.println("result:"+sourceByResult);
        return "OK";
    }

    @Override
    public String performPost(List<String> indexs, List<String> types, String query) throws IOException {
        String index = StringUtils.join(indexs, ",");
        String type = "/";
        if (Objects.nonNull(types) && !types.isEmpty()) {
            type += StringUtils.join(types, "/") + "/";
        }
        HttpEntity entity = new NStringEntity(query, ContentType.APPLICATION_JSON);
        String endpoint = "/" + index + type + "_search";
        Response response = rsc.performRequest(POST, endpoint, Collections.singletonMap("pretty", "true"), entity);
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    public String performPut(String index, String type, String id, String data) throws IOException {
        HttpEntity entity = new NStringEntity(data, ContentType.APPLICATION_JSON);
        String requestType = POST;
        String endpoint = "/" + index + "/" + type;
        if (StringUtils.isNoneBlank(id)) {
            requestType = PUT;
            endpoint = "/" + index + "/" + type + "/" + id;
        }
        Response response = rsc.performRequest(requestType, endpoint, Collections.singletonMap("pretty", "true"), entity);
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    public String performDelete(String index) throws IOException {
        return performDelete(index, null, null);
    }

    @Override
    public String performDelete(String index, String type) throws IOException {
        return performDelete(index, type, null);
    }

    @Override
    public String performDelete(String index, String type, String id) throws IOException {
        String endpoint = "/" + index + "/" + type + "/" + id;
        if (StringUtils.isBlank(id)) {
            endpoint = "/" + index + "/" + type;
        } else if (StringUtils.isBlank(type)) {
            endpoint = "/" + index;
        }
        Response response = rsc.performRequest(DELETE, endpoint);
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    public boolean performHead(String index, String type) throws IOException {
        int code = 200;
        String endpoint = "/" + index + "/" + type;
        if (StringUtils.isBlank(type)) {
            endpoint = "/" + index;
        }
        Response response = rsc.performRequest(HEAD, endpoint);
        code = response.getStatusLine().getStatusCode();
        return code == 200;
    }
}
