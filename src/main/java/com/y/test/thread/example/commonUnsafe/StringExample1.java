package com.y.test.thread.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class StringExample1 {
    private static Map map = new HashMap();
    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int x = 0; x < clientTotal; x++){
            final int index = x;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
                    put(index);
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
        log.info("size:{}", sb.length());
        log.info("size:{}", map.size());
    }

    private static void update(){
        sb.append("1");
    }

    private static void put(int x){
        map.put(x, x);
    }

}
