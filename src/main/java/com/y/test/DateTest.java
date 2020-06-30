package com.y.test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DateTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        int year = now.getYear();
        System.out.println(year);

        // 获得1970 1 1 0 0 0 到现在的毫秒数

        System.out.println(Calendar.getInstance().getTimeInMillis());
        //第一种方式
        System.out.println(System.currentTimeMillis());
        // 二种方式
        // Java 8
        System.out.println(Clock.systemDefaultZone().millis());

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

        LocalDateTime of1 = LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 0));
        System.out.println(of1.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));


        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));

        System.out.println(LocalDate.parse("2018-08-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")).getYear());
        System.out.println(localDateTime.getMonthValue());


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 5,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
    }
}
