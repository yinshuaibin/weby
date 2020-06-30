package com.y.test.jichu;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author yinshuaibin
 * @date 2020/6/11 9:34
 */
public class BigNumber {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("9999999").pow(99);
        float v = b1.floatValue();
        // Infinity  超出了最大值, 将会出现此结果
        System.out.println(v);
        BigDecimal b = new BigDecimal("123000");
        BigDecimal bigDecimal = b.stripTrailingZeros();
        BigDecimal b2 = new BigDecimal("1234.00");
        BigDecimal bigDecimal1 = b2.stripTrailingZeros();
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal1.scale());
    }
}
