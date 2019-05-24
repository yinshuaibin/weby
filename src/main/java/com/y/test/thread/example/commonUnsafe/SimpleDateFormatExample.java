package com.y.test.thread.example.commonUnsafe;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SimpleDateFormatExample {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

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
                    semaphore.release();
                }catch (Exception e){

                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            Collections.synchronizedList(Lists.newArrayList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void update(){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

            format.parse("20190101");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
