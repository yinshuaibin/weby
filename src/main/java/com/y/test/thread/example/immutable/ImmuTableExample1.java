package com.y.test.thread.example.immutable;

import com.google.common.collect.Maps;
import com.y.test.thread.annontions.NotThreadSafe;

import java.util.Map;

@NotThreadSafe
public class ImmuTableExample1 {

    private final static Integer a = 1;
    private static final String b = "2";
    private final static Map<Integer, Integer> map = Maps.newConcurrentMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
       // 普通数据类型不可修改值, 引用类型数据不可指向新的对象
    }
}
