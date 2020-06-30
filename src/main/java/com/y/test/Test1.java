package com.y.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
       for (int x = 0; x < names.length; x++){
           System.out.println(names[x]);
       }

        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416

        double a = 1 - 9.0/10;
        if (Math.abs(a - 0.1) < 0.0000001){ // 浮点数比较
            System.out.println("a is 0.1");
        }else {
            System.out.println("a is not 0.1");
        }

        int m = 20;
        int n = 100;
        int sum = 0;
        do {
            sum += m;
            m++;
        }while (m <= n);
        System.out.println(sum);

        int m1 = 20;
        int n1 = 100;
        int sum1 = 0;
        while (m1 <= n1){
            sum1 += m1;
            m1++;
        }
        System.out.println(sum1);

        int[] arr = {26,1};
        for (int x = 0; x < arr.length; x++){
            for (int y = 0; y <arr.length - x - 1; y++){
                if (arr[y] > arr[y + 1]){
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
        for (int x : arr){
            System.out.println(x);
        }
        List<Integer> abc = new ArrayList<>();
        abc.add(3);
        abc.add(2);
        abc.add(100);
        abc.add(90);
        sort(abc, true);
        System.out.println(abc);
    }

    // 冒泡排序
    private static void sort(List<Integer> intList, boolean desc){
        if (desc){
            for (int x = 0; x < intList.size(); x++){
                for (int y = 0; y < intList.size() - x -1; y++){
                    int attr = intList.get(y);
                    int attr1 = intList.get(y+1);
                    if (attr > attr1){
                        intList.set(y+1, attr);
                        intList.set(y, attr1);
                    }
                }
            }
        }
    }
}
