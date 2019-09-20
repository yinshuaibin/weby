package com.y.test.thread.test;

import com.y.test.thread.annontions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest2 {

    private static Map map = new HashMap();
    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    private static int count = 0;
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(1);
        linkedBlockingQueue.offer(1);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int x = 0; x < clientTotal; x++){
            final int index = x;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    Integer take;
                    take = linkedBlockingQueue.take();
                    if (take.equals(10000)) take = 1;
                    add(take);
                    linkedBlockingQueue.offer(take + 1);
                    put(take);
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
        log.info("count:{}", set.size());
        log.info("size:{}", map.size());
    }

    private static void add(int a){
        set.add(a);
    }

    private static void put(int x){
        map.put(x, x);
    }

}
