package com.y.test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        int year = now.getYear();
        System.out.println(year);

        // 获得1970 1 1 0 0 0 到现在的毫秒数
        Calendar.getInstance().getTimeInMillis();
        //第一种方式
        System.currentTimeMillis();
        // 二种方式
        // Java 8
        Clock.systemDefaultZone().millis();

        // 获取当月最后一天
        LocalDate now1 = LocalDate.now();
        LocalDate of = LocalDate.of(now1.getYear(), now1.getMonth(), 1);
        System.out.println(of);
        String s = of.toString();
        System.out.println(s);

        // 获取当月最后一天
        LocalDate with = now1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with.toString());

        // 格式化时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = now1.format(dateTimeFormatter);
        System.out.println(format);

        // 获取前一天这个时刻
        LocalDateTime localDateTime = now.minusDays(1);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
