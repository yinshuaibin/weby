package com.y.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class TestServiceImpl {

    private LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(16);

    @PostConstruct
    public void init(){
        ExecutorService exec = Executors.newFixedThreadPool(3);
        long l = System.currentTimeMillis();
        for(int a=0; a<3; a++){
            exec.execute(new aaaaaa());
        }
    }
    void offer(){
        boolean offer = linkedBlockingDeque.offer("123");
    }
    void working(){
        try {
            Object take = linkedBlockingDeque.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private class aaaaaa implements  Runnable{

        @Override
        public void run() {
            try {
                Object take = linkedBlockingDeque.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
