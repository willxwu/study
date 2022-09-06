package com.example.study.java8.streams;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Stream使用
 * Stream操作分为：2组，//注意，流式管道操作，只能操作一次，否则报错
 * You can see two groups of operations:
 * 1、可连续操作
 *  filter, map, and limit can be connected together to form a pipeline.
 * 2、操作中断
 *  collect causes the pipeline to be executed and closes it.
 */
public class SimpleStream {
    public static void main(String[] args) {
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

        Stream<Dish> stream = menu.stream();
        stream.forEach(System.out::println);
        //注意，流式管道操作，只能操作一次，否则报错
        //stream has already been operated upon or closed
//        stream.forEach(System.out::println);

        System.out.println("====================================");

        //原始调用
        List<String> namesByCollections = getDishNamesByCollections(menu);
        namesByCollections.stream().forEach(System.out::println);

        System.out.println("====================================");

        //lambda stream调用
        List<String> lambdaStreamNames = lambdaStream(menu);
        lambdaStreamNames.stream().forEach(System.out::println);

    }

    //原始写法
    public static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> caloriesDis = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                caloriesDis.add(dish);
            }
        }
        Collections.sort(caloriesDis, (dish1, dish2) -> {
            return Integer.compare(dish1.getCalories(), dish2.getCalories());
        });

        List<String> names = new ArrayList<>();
        for(Dish dish : caloriesDis){
            names.add(dish.getName());
        }
        return names;
    }

    //stream lambda处理
    public static List<String> lambdaStream(List<Dish> menu){
        return menu.stream().filter(dis -> dis.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());
    }
}
