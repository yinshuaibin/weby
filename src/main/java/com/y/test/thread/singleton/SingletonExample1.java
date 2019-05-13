package com.y.test.thread.singleton;

import com.y.test.thread.annontions.NotThreadSafe;

/**
 * 懒汉式, 单例实例在第一次使用的时候创建
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1(){}

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if(instance == null) instance = new SingletonExample1();
        return instance;
    }
}
