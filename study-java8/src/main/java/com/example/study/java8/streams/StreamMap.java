package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Stream map
 */
public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        String[] arrays = {"Hello","world"};

        //1、map
        List<Integer> mapResult = list.stream().map(i -> i * 2).collect(toList());
        mapResult.stream().forEach(System.out::println);

        System.out.println("=============================");

        //2、map
        menu.stream().map(Dish::getName).forEach(System.out::println);
        System.out.println("=============================");

        //3、flatMap 扁平化
        //拆分成String[]: {h,e,l,l,o}，{w,o,r,l,d}
        Stream<String[]> splitStream = Arrays.stream(arrays).map(s -> s.split(""));
        //flatMap扁平化，将{h,e,l,l,o}，{w,o,r,l,d}每个数组转成Stream<String>
        Stream<String> stringStream = splitStream.flatMap(Arrays::stream);
        stringStream.distinct().forEach(System.out::println);
        //打印结果
        /**
         H
         e
         l
         o
         w
         r
         d
         *
         */
    }
}
