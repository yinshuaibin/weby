package com.y.test.thread.example.immutable;

import com.google.common.collect.Maps;
import com.y.test.thread.annontions.ThreadSafe;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class ImmuTableExample2 {


    private static Map<Integer, Integer> map = Maps.newConcurrentMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
        // 被Collections.unmodifiabl修饰后, 不可进行修改操作
    }

    public static void main(String[] args) {
       // 普通数据类型不可修改值, 引用类型数据不可指向新的对象
    }
}
