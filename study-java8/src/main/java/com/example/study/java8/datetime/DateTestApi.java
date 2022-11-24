package com.example.study.java8.datetime;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * java8 Date and Time API：LocalDate 线程安全
 */
public class DateTestApi {
    public static void main(String[] args) throws InterruptedException {
//        testLocalDate();

//        testLocalTime();
//        combineLocalDateAndTime();
//        testInstant();
//        testDuration();
//        testPeriod();
//        testLocalDateFormat();
        testLocalDateParse();
    }

    //API-7 format 日期时间格式化成字符串
    private static void testLocalDateParse() {
        //字符串日期转date类型，注意字符串格式和要转换的格式要一样
        String date = "2022-11-24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);

        //字符串时间转time类型，注意字符串格式和要转换的格式要一样
        String time = "20:38:24";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(time, timeFormatter);
        System.out.println(localTime);

        //字符串日期时间转datetime类型，注意字符串格式和要转换的格式要一样
        String dateTime = "2022/11/24 20:59:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
        System.out.println(localDateTime);
    }

    //API-7 format 日期时间格式化成字符串
    private static void testLocalDateFormat() {
        //日期格式化
        LocalDate date = LocalDate.now();
        String basicDate = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        //日期时间格式化
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(basicDate);
        System.out.println(time);

        //自定义格式化格式
        LocalDateTime localDateTime = LocalDateTime.now();
        //自定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTIme = localDateTime.format(formatter);
        System.out.println(formatDateTIme);
    }

    //API-6 Period 时代、周期
    private static void testPeriod() {
        Period period = Period.between(LocalDate.of(2000, 10, 9), LocalDate.of(2022, 12, 13));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }


    //API-5 Duration 时间段
    private static void testDuration() {
        LocalTime start = LocalTime.now();
        //减1小时
        LocalTime end = start.minusHours(1);
        //开始到结束
        Duration durationBetween = Duration.between(end, start);
        //用了多少小时
        System.out.println(durationBetween.toHours());
    }

    //API-4 Instant 时间点，时刻，点
    private static void testInstant() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000L);
        Instant end = Instant.now();
        //Duration  时间段
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    // API-3:  LocalDateTime  日期时间
    private static void combineLocalDateAndTime() {
        // 整合LocalDate和LocalTIme
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        //直接获取当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //获取日期时间，是一周中的周几，其它api方法用法一样
        System.out.println(now.getDayOfWeek());
    }


    // API-2:  LocalTime  时间
    private static void testLocalTime() {
        //获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //时
        System.out.println(time.getHour());
        //分
        System.out.println(time.getMinute());
        //秒
        System.out.println(time.getSecond());
    }

    // API-1:  LocalDate  日期
    private static void testLocalDate() {

        //1、LocalDate
        LocalDate localDate = LocalDate.of(2022, 11, 23);
        System.out.println(localDate);
        //获取年
        System.out.println(localDate.getYear());
        //获取月
        System.out.println(localDate.getMonth());
        //今年的第几天
        System.out.println(localDate.getDayOfYear());
        //这个月的第几天
        System.out.println(localDate.getDayOfMonth());
        //这一周的星期几
        System.out.println(localDate.getDayOfWeek());

        //整数：这个月的第几天
        //其它枚举值用法一样
        int dayOfMoth = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMoth);

        //获取当前时间
        LocalDate nowLocalDate = LocalDate.now();
        System.out.println(nowLocalDate);
    }
}
