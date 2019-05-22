package com.y.test.thread.example.singleton;

import com.y.test.thread.annontions.NotThreadSafe;

/**
 * 懒汉式 -->双重同步锁
 * 单例实例在第一次使用的时候创建
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4(){}

    // 1 memory = allocate()分配对象的内存空间
    // 2 ctorInstance() 初始化对象
    // 3 instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化, 发生了指令重排
    // 1 memory = allocate()分配对象的内存空间
    // 3 instance = memory 设置instance指向刚分配的内存
    // 2 ctorInstance() 初始化对象

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance(){
        if(instance == null) {
            synchronized (SingletonExample1.class){
                if (instance == null) instance = new SingletonExample4();
            }
        }
        return instance;
    }
}
