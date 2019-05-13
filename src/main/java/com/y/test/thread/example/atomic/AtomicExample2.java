package com.y.test.thread.example.atomic;

import com.y.test.thread.annontions.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
// https://www.cnblogs.com/itermis/p/9004041.html CountDownLatch Semaphore介绍
public class AtomicExample2 {

    private static Map map = new HashMap();
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    // AtomicLong   LongAdder 具有同样的效果, LongAdder效率高一点, 但是可能会出现部分误差
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 解决类似排队问题
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 解决线程执行顺序问题
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int x = 0; x < clientTotal; x++){
            final int index = x;
            executorService.execute(()->{
                try {
                    semaphore.acquire(); // 获取信号量
                    add();
                    put(index);
                    semaphore.release();// 释放信号量
                }catch (Exception e){

                }
                countDownLatch.countDown(); // 减少等待线程个数
            });
        }
        try {
            countDownLatch.await();// 等待计数结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        log.info("count:{}", count.get());
        log.info("size:{}", map.size());
    }

    private static void add(){
        count.incrementAndGet();
//        count.getAndIncrement();
    }

    private static void put(int x){
        map.put(x, x);
    }

}
