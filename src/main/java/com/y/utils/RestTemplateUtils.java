package com.y.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


/**
 * 如使用RestTemplate 可以使用@Autowired注入方式, 也可使用RestTemplateUtils.restTemplate
 * postForEntity方法为设置了spplication/json头的utf8编码的http请求
 */
@Configuration
@Order(1)
public class RestTemplateUtils implements CommandLineRunner {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public HttpHeaders httpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json");
        headers.setContentType(type);
        return headers;
    }

    public static RestTemplate restTemplate;

    private static HttpHeaders httpHeaders;

    public static String postForEntity(String url, Object o){
        HttpEntity entity = new HttpEntity(o, httpHeaders);
        return restTemplate.postForEntity(url, entity, String.class).getBody();
    }

    @Override
    public void run(String... args) throws Exception {
        this.restTemplate = restTemplate();
        this.httpHeaders = httpHeaders();
    }
}
