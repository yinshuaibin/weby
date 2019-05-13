package com.y.test.thread.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    // 修饰类, 作用对象为所有对象
    public void test1(){
        synchronized (SynchronizedExample2.class){
            for (int x = 0; x < 10; x++){
                log.info("test1: {}", x);
            }
        }
    }

    //修饰静态方法, 作用对象为所有对象
    public static synchronized void test2(){
        for (int x = 0; x < 10; x++){
            log.info("test2: {}", x);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizedExample1.test1();
        });
        executorService.execute(()->{
            synchronizedExample2.test1();
        });
    }
}
