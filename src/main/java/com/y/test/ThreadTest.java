package com.y.test;

public class ThreadTest {

    public static void main(String[] args) {
        testThread();
    }

    private static void testThread(){
        yRunable ist = new yRunable();
        Thread th = new Thread(ist);
        System.out.println("Main begin th isAlive = " + th.isAlive());
        th.start();
        System.out.println("Main end th isAlive = " + th.isAlive());
    }

    static class yRunable implements Runnable{

        public yRunable() {
            System.out.println("begin");
            System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive());
            System.out.println("end");
        }

        @Override
        public void run() {
            System.out.println("run begin");
            System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive());
            System.out.println("run end");
        }
    }

}
