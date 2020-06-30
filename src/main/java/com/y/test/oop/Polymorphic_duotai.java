package com.y.test.oop;

import java.util.ArrayList;

/**
 * @author yinshuaibin
 * @date 2020/6/10 10:03
 */
public class Polymorphic_duotai {
    public static void main(String[] args) {
        Double taxs = getTaxs(new Salary[]{
                new Salary(10000D, 2000D)
        });
//        getTaxs(new Salary(10000D, 2000D));
        System.out.println(taxs);
    }

    public static Double getTaxs(Income... incomes){
        Double tax = 0D;
        for (Income income : incomes){
            tax += income.getTax();
        }
        return tax;
    }

}
class Income{
    // 总收入
    protected Double income;
    // 普通税率
    public double getTax() {
        return income * 0.1; // 税率10%
    }

    public Income (Double income){
        this.income = income;
    }
}

class Salary extends Income{

    private Double gaofei;

    public Salary(Double income, Double gaofei) {
        super(income);
        this.gaofei = gaofei;
    }

    @Override
    public double getTax() {
        Income instance = new Income(gaofei);
        double gongzi = income - gaofei;
        if (gongzi  > 5000){
            return (gongzi - 5000) * 0.2 + instance.getTax();
        }
        return instance.getTax();
    }
}

