package com.example.study.java8.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 旧API问题重现
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        //122格林威治时间  11月  23日期
        //问题：不能清晰表示日期
        Date date = new Date(122, 11, 23);
        System.out.println(date);

        //多线程情况下会出现一些问题：
        //30个线程，每个线程下循环100次，执行时间格式转换。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    Date parseDate = null;
                    try {
                        parseDate = sdf.parse("20221123");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(parseDate);
                }
            }).start();
        }
    }
}
