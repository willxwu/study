package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Stream reduce：聚合作用，根据reduce传入的Function条件进行聚合
 * 用法：只要reduce里面参数满足funcion就可以
 */
public class StreamReduce {
    public static void main(String[] args) {
        //用法：只要reduce的参数满足Function就可以

        //reduce(0, (i, j) -> i + j)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        Integer reduceResult = list.stream().reduce(0, (i, j) -> i + j);
        System.out.println(reduceResult);

        System.out.println("===================================");

        //reduce((i,j)->i+j)
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        list.stream().reduce((i,j)->i+j).ifPresent(System.out::println);

        System.out.println("===================================");
        //reduce(Math::max)
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        list.stream().reduce(Math::max).ifPresent(System.out::println);

        System.out.println("===================================");

        //reduce(Integer::sum)
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);

    }
}
