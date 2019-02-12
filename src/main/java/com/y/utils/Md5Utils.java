package com.y.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Utils {
    private static final String ALGORITH_NAME = "md5";
    private static final String salt = "666666";

    public static String md5Encryption(String ciphertext){
        return new SimpleHash(ALGORITH_NAME, ciphertext, salt).toString().toString();
    }
}
