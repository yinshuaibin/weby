package com.y.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yinshuaibin
 * @date 2020/6/9 11:18
 */
public class FutureTest {
    public static String test1(long time){
        try {
            Thread.sleep(time);
            return "time" + time;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池,
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 111,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10000));

        List<Future> a = new ArrayList<>();


        a.add(threadPoolExecutor.submit(() -> test1(3000)));
        a.add(threadPoolExecutor.submit(() -> test1(3000)));
        a.add(threadPoolExecutor.submit(() -> test1(6000)));
        long start1 = System.currentTimeMillis();
        for (Future f: a){
            try {
                long start = System.currentTimeMillis();
                Object o = f.get();
                System.out.println(o + "耗时" + (System.currentTimeMillis() - start));
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("timeout");
            }
        }
        System.out.println( "总耗时" + (System.currentTimeMillis() - start1));
        threadPoolExecutor.shutdown();
    }
}
