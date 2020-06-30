package com.y.test.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/10 10:18
 */
public class Inteface_jiekou {
    public static void main(String[] args) {
        Double taxs = getTaxs(new Salary2(8000D),
                new Salary3(2000D));
        System.out.println(taxs);
    }

    public static Double getTaxs(Income_interface... income_interfaces){
        Double result = 0D;
        for (Income_interface i : income_interfaces){
            result += i.getTax();
        }
        return result;
    }
}



interface Income_interface{
    Double getTax();
}

class Salary2 implements Income_interface{

    private Double income;

    @Override
    public Double getTax() {
        if (income  > 5000){
            return (income - 5000) * 0.2;
        }
        return 0D;
    }

    public Salary2(Double income){
        this.income = income;
    }
}

class Salary3 implements Income_interface{

    private Double income;

    @Override
    public Double getTax() {
        return income * 0.1;
    }

    public Salary3(Double income){
        this.income = income;
    }
}