package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Stream filter
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);

        //filter 过滤
        List<Integer> filterResult = list.stream().filter(i -> i % 2 == 0).collect(toList());
        filterResult.stream().forEach(System.out::println);

        System.out.println("===================================");

        //distinct 去重
        List<Integer> distinctResult = list.stream().distinct().collect(toList());
        distinctResult.stream().forEach(System.out::println);

        System.out.println("===================================");

        //skip 截断(跳过前面几个,超过长度，直接返回空)
        List<Integer> skipResult = list.stream().skip(5).collect(toList());
        skipResult.stream().forEach(System.out::println);

        System.out.println("===================================");

        //limit 查询几条
        List<Integer> limitResult = list.stream().limit(3).collect(toList());
        limitResult.stream().forEach(System.out::println);
    }
}
