package com.y.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    private static AtomicInteger size = new AtomicInteger(10);


    public static void main(String[] args) throws FileNotFoundException {
        for (int x = 0; x < 8; x++){
            new Thread(()->{
                cycle();
            }).start();
        }

        try (InputStream inputStream = new FileInputStream("jpg")){
            
        }catch (Exception e){

        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println("进来了");
                    size.decrementAndGet();
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            test(size.get());
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void test(int size){
        System.out.println("执行开始了_" + size);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束了_" + size);
    }

    static void cycle(){
        int i = 0;
        while (true){
            i++;
        }
    }
}
