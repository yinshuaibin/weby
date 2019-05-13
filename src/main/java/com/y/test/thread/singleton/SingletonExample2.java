package com.y.test.thread.singleton;

import com.y.test.thread.annontions.ThreadSafe;

/**
 * 饿汉式 单例实例在类装载使用时进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2(){}

    // 还可以使用静态代码块来初始化
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
