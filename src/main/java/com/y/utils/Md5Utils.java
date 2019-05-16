package com.y.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.io.File;

public class Md5Utils {
    private static final String ALGORITH_NAME = "md5";
    // 固定的盐salt
    public static final String salt = "666666";
    // 加密次数
    public static final int hashiterations = 100;


    public static String md5Encryption(String ciphertext){
        return new SimpleHash(ALGORITH_NAME, ciphertext, salt ,hashiterations).toString();
    }

}
