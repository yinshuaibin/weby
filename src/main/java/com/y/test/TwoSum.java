package com.y.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;

/**
 * @author yinshuaibin
 * @date 2020/4/30 10:09
 *
 * @desc 给定int数组, 给定一个值, 求可以相加得到这个值的2个索引
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5,4,8};
        int target = 9;
        Map<Integer, Integer> tempMap = new HashMap<>();
        List<int[]> listResult = new ArrayList<>();
        int len = a.length;
        for ( int x = 0; x < len; x++){
           int tem =  target - a[x];
           if (tempMap.containsKey(tem)){
               int[] resultTemp = {x, tempMap.get(tem)};
               listResult.add(resultTemp);
           }
           tempMap.put(a[x], x);
        }
        for (int[] result1: listResult){
            System.out.println(Arrays.toString(result1));
        }
    }

}
