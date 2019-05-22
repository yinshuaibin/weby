package com.y.test.thread.singleton;

import com.y.test.thread.annontions.Recommend;
import com.y.test.thread.annontions.ThreadSafe;

/**
 * 枚举模式, 安全, 不需要做复杂的操作
 */
@ThreadSafe
@Recommend
public class SingletonExample6 {

    private SingletonExample6(){}

    public static SingletonExample6 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private SingletonExample6 singletonExample6;

        // JVM保证这个方法绝对只调用一次
        Singleton(){
            singletonExample6 = new SingletonExample6();
        }

        public SingletonExample6 getInstance(){
            return singletonExample6;
        }
    }
}
