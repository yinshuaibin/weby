package com.y.test.thread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CyclicBarrierExample3 {

    // 阻塞信号量, 达到阻塞信号量以后, 优先执行此处的Runnable
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () ->{
        log.info("call back is running");
    });

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for( int x = 0; x < 10; x++){
            Thread.sleep(1000);
            final int num = x;
            executorService.execute( () ->{
                try {
                    race(num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int num) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", num);
        // 对使用此方法的线程进行阻塞, 直到阻塞的线程数达到信号量, 然后才开始向下执行
        cyclicBarrier.await();
        log.info("{} continue", num);
    }
}
