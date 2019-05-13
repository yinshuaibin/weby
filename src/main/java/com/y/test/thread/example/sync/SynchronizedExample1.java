package com.y.test.thread.example.sync;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    // 修饰代码块, 作用对象为调用该代码块的对象
    public void test1(){
        synchronized (this){
            for (int x = 0; x < 10; x++){
                log.info("test1: {}", x);
            }
        }
    }

    // 修饰代码块, 作用对象为调用该代码块的对象
    public void test3(int y){
        synchronized (this){
            for (int x = 0; x < 10; x++){
                log.info("test1: y->{}, {}", y, x);
            }
        }
    }

    //修饰方法, 作用对象为调用该方法的对象
    public synchronized void test2(){
        for (int x = 0; x < 10; x++){
            log.info("test2: {}", x);
        }
    }

    //修饰方法, 作用对象为调用该方法的对象
    public synchronized void test4(int y){
        for (int x = 0; x < 10; x++){
            log.info("test2: y->{}, {}", y, x);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            synchronizedExample1.test1();
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test1();
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test2();
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test2();
//        });

        // 以下8行乱序输出
//        executorService.execute(()->{
//            synchronizedExample1.test3(1);
//        });
//        executorService.execute(()->{
//            synchronizedExample2.test3(2);
//        });
        executorService.execute(()->{
            synchronizedExample1.test4(1);
        });
        executorService.execute(()->{
            synchronizedExample2.test4(2);
        });
    }
}
