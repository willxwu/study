package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Stream - Match匹配
 */
public class StreamMatch {
    public static void main(String[] args) {
        Stream<Integer> list = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        //1、allMatch 全部满足条件
        boolean booleanAnyMath = list.allMatch(i -> i > 0);
        System.out.println(booleanAnyMath);

        //2、anyMatch 任意一个满足条件
        list = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean anyMatch = list.anyMatch(i -> i > 9);
        System.out.println(anyMatch);

        //3、noneMatch 没有一个满足
        list = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean noneMatch = list.noneMatch(i -> i == 11);
        System.out.println(noneMatch);
    }
}
