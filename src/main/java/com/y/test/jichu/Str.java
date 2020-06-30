package com.y.test.jichu;

import java.math.BigInteger;
import java.util.StringJoiner;

/**
 * @author yinshuaibin
 * @date 2020/6/10 15:35
 */
public class Str {
    public static void main(String[] args) {
        String s = "fffF";
        String s2= "ffFf";
        boolean b = s.equalsIgnoreCase(s2);
        System.out.println(s2.contains("fff"));
        System.out.println(b);

        StringJoiner sj = new StringJoiner("', '", "('", "')");
        for (int x = 0; x < 10; x++){
            sj.add(x+"");
        }
        System.out.println(sj);
        System.out.println((int)(230 * 0.05));
        BigInteger b1 = new BigInteger("9999999").pow(99);
        float v = b1.floatValue();
        System.out.println(v);
    }

}
