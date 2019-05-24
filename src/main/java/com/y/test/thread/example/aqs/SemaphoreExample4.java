package com.y.test.thread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample4 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建信号量
        Semaphore semaphore = new Semaphore(3);
        for (int x = 0; x<threadCount; x++){
            final int threadNum = x;
            executorService.execute( () ->{
                try {
                    // 拿到许可
                    if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){// 尝试拿到许可, 如果拿不到, 则不执行
                        test(threadNum);
                        // 释放许可
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
