package com.y.test.thread.example.count;

import com.y.test.thread.annontions.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class CountExample2 {

    private static Map map = new HashMap();
    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int x = 0; x < clientTotal; x++){
            final int index = x;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
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
        log.info("count:{}", count);
        log.info("size:{}", map.size());
    }

    private synchronized static void add(){
        count++;
    }

    private synchronized static void put(int x){
        map.put(x, x);
    }

}