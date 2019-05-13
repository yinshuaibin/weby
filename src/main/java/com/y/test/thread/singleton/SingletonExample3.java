package com.y.test.thread.singleton;

import com.y.test.thread.annontions.NotRecommend;
import com.y.test.thread.annontions.ThreadSafe;

/**
 * 懒汉式, 单例实例在第一次使用的时候创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3(){}

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance(){
        if(instance == null) instance = new SingletonExample3();
        return instance;
    }
}
