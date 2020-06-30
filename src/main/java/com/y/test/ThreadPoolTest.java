package com.y.test;


import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yinshuaibin
 * @date 2020/6/2 9:42
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception {
        // newFixedThreadPoolOOM();
        threadPoolExecutorTest();
    }

    // 实际测试并不会oom, 原因是默认的jvm内存够大, 导致oom的原因是
    // newFixedThreadPool
    private static void newFixedThreadPoolOOM(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int x = 0; x < Integer.MAX_VALUE; x++){
            executorService.execute(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void threadPoolExecutorTest() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor t = new ThreadPoolExecutor(5, 6,
                60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3000), Executors.defaultThreadFactory());

        List<Future> results = new ArrayList<>();
        for (int x = 0; x < 4; x ++) {
            int finalX = x;
            Future<?> submit = t.submit(() -> {
                System.out.println("current thread name" + finalX);
                if (finalX == 2) {
//                    int a = 1/0;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return finalX;
            });
            System.out.println(finalX+ " 已经开始执行");
            results.add(submit);
        }
        for (Future f : results){
            System.out.println(f.get());
        }
        t.shutdown();
    }
}
