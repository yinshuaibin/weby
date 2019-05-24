package com.y.test.thread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

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
                    semaphore.acquire(3); // 可以一次性拿到多个, 释放多个, 经过测试, 如果一次拿到的信号量大于总信号量, 将会卡死
                    test(threadNum);
                    // 释放许可
                    semaphore.release(3);
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
