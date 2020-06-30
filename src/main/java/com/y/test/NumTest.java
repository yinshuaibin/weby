package com.y.test;

/**
 * @author yinshuaibin
 * @date 2020/6/23 10:03
 */
public class NumTest {

    public static void main(String[] args) {
        int n = 3;
        System.out.println((n & 1) == 0 ? "偶数" : "奇数");
        // 右移1位, 相当于/2, 右移2位, 相当于/4
        System.out.println(n >> 1);
        // 左移1位, 相当于*2, 左移2位, 相当于*4
        System.out.println(n << 1);
    }
}
