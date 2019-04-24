package com.java.code.study.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zouw
 * @date Created in 10:27 AM 2019/4/10
 */
@Component
//prefix 和application.yml一致
@ConfigurationProperties(prefix = "elasticsearch-props")
public class RestClientConfig {

    private String clusterName;

    private List<Map<String, Integer>> clusterNodes = new ArrayList<>();
    private String scheme;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    private RestClient restClient;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }


    public List<Map<String, Integer>> getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(List<Map<String, Integer>> clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public RestClient getRestClient() {
        if (restClient == null) {
            init();
        }
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    private void init() {
        List<HttpHost> httpHosts = new ArrayList<HttpHost>();

        for (Map<String, Integer> cns : clusterNodes) {
            for (Map.Entry<String, Integer> entry : cns.entrySet()) {
                httpHosts.add(new HttpHost(entry.getKey(), entry.getValue(), scheme));
            }
        }

        HttpHost[] hh = (HttpHost[]) httpHosts.toArray(new HttpHost[0]);//list to array
        this.setRestClient(RestClient.builder(hh).build());
        System.out.println("init elasticsearch RestClient clusterName " + clusterName + " clusterNodes " + clusterNodes.toString());
    }

}
