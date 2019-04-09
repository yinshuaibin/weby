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

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ftpImgDir = "D:\\FaceImage";
                File f = new File(ftpImgDir);
                while (true){
                    File[] files = f.listFiles();
                    if(files.length>0){
                        System.out.println(1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
