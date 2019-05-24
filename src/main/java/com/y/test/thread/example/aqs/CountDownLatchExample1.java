package com.y.test.thread.example.aqs;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample1 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int x = 0; x<threadCount; x++){
            final int threadNum = x;
            executorService.execute( () ->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 如果这里写了时间, 那么将全部请求放进去以后开始计时, 超过这个时间以后, 将无论方法是否执行完毕, 都开始执行下边的程序
        // 如果不写时间, 将会等待全部线程执行完毕后, 才可是执行下边的程序
        countDownLatch.await(99, TimeUnit.MILLISECONDS);
        log.info("finish");
        // 执行到此步骤的时候线程池中还有线程在运行, 线程池并不会清空,而是会等待所有线程全部运行完成,才会清空线程池
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
