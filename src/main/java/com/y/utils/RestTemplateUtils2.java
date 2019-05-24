package com.y.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

// 此处和上个一个restTemplateUtils效果相同, 均为单例
@Configuration
@Slf4j
public class RestTemplateUtils2 implements CommandLineRunner {

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

    private static RestTemplate restTemplate;

    private static HttpHeaders httpHeaders;

    @Autowired
    public void setRestTemplate(@Qualifier("restTemplate") RestTemplate restTemplate){
        RestTemplateUtils2.restTemplate = restTemplate;
    }

    @Autowired
    public void setHttpHeaders(@Qualifier("httpHeaders") HttpHeaders httpHeaders){
        RestTemplateUtils2.httpHeaders = httpHeaders;
    }

    public static String postForObject(String url, Object o){
        HttpEntity entity = new HttpEntity(o, httpHeaders);
        return restTemplate.postForEntity(url, entity, String.class).getBody();
    }

    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static ConcurrentHashMap map = new ConcurrentHashMap();
    private static ConcurrentHashMap map2 = new ConcurrentHashMap();

    @Override
    public void run(String... args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int x = 0; x < clientTotal; x++){
            final int index = x;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test(index);
                    semaphore.release();
                }catch (Exception e){

                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        log.info("map: {}", map.size());
        log.info("map2: {}", map2);
    }

    private void test(int index){
        map.put(index, index);
        map2.put(RestTemplateUtils.restTemplate, index);
    }
}
