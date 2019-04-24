package com.java.code.study.service;

import java.io.IOException;
import java.util.List;

/**
 * @author zouw
 * @date Created in 10:53 AM 2019/4/10
 */
public interface EsBasicService {

     String performGet(String index,String type,String query) throws IOException ;

     String performPost(List<String> indexs, List<String> types, String query) throws IOException;

     String performPut(String index,String type,String id,String data) throws IOException ;

     String performDelete(String index) throws IOException;

     String performDelete(String index,String type) throws IOException;

     String performDelete(String index,String type,String id) throws IOException ;

     boolean performHead(String index,String type) throws IOException ;
}