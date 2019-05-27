package com.y.test.thread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    // 阻塞信号量
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

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
        // 如果方法传入了等待时间, 即超过等待时间即往下执行, 那么需要手动抓取该方法可能出现的异常
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.warn("InterruptedException", e);
        } catch (BrokenBarrierException e) {
            log.warn("BrokenBarrierException", e);
        } catch (TimeoutException e) {
            log.warn("TimeoutException", e);
        }
        log.info("{} continue", num);
    }
}
