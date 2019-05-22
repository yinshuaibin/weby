package com.y.test.thread.singleton;

import com.y.test.thread.annontions.NotThreadSafe;
import com.y.test.thread.annontions.ThreadSafe;

/**
 * 懒汉式 -->双重同步锁
 * 单例实例在第一次使用的时候创建
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5(){}

    // 1 memory = allocate()分配对象的内存空间
    // 2 ctorInstance() 初始化对象
    // 3 instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化, 发生了指令重排
    // 1 memory = allocate()分配对象的内存空间
    // 3 instance = memory 设置instance指向刚分配的内存
    // 2 ctorInstance() 初始化对象
    // 使用volatile可以在此处限制指令重排, 变成线程安全的单例

    // 单例对象 volatile + 双重检测机制 --> 禁止指令重排(因为此处运用了volatile的写操作)
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance(){
        if(instance == null) { // 双重检测机制
            synchronized (SingletonExample1.class){
                if (instance == null) instance = new SingletonExample5();
            }
        }
        return instance;
    }
}
