package com.y.test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yinshuaibin
 * @date 2020/4/30 10:40
 * enterSet iterator方式最快, 删除线程安全
 */
public class MapTest {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        // stream单线程
        map.entrySet().stream().forEach((item) ->{
            String key = item.getKey();
            String value = item.getValue();
        });

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
        }

        //stream多线程
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

}
