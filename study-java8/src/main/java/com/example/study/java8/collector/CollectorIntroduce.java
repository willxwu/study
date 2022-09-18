package com.example.study.java8.collector;

import com.example.study.java8.function.Apple;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Collector 简单举例
 */
public class CollectorIntroduce {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("red", 10)
                , new Apple("red", 60)
                , new Apple("blue", 40)
                , new Apple("black", 30)
                , new Apple("green", 80)
                , new Apple("blue", 90)
                , new Apple("green", 60)
                , new Apple("green", 50)
                , new Apple("red", 20));
        //1、聚合作用
        List<Apple> greenCollect = list.stream().filter(a -> "green".equals(a.getColor())).collect(Collectors.toList());
        Optional.ofNullable(greenCollect).ifPresent(System.out::println);

        //2、分组作用
        //原始写法
        Optional.ofNullable(getAppleByColorGroup(list)).ifPresent(System.out::println);
        //函数式分组写法
        Optional.ofNullable(getAppleByFunction(list)).ifPresent(System.out::println);
        //collector最精华写法
        Optional.ofNullable(getAppleByCollect(list)).ifPresent(System.out::println);
    }

    //collect精华写法
    public static Map<String,List<Apple>> getAppleByCollect(List<Apple> list) {
//        return list.stream().collect(Collectors.groupingBy(Apple::getColor));
        return list.stream().collect(groupingBy(Apple::getColor));
    }

    /**
     * 函数式分组实现
     * @param list
     * @return
     */
    public static Map<String, List<Apple>> getAppleByFunction(List<Apple> list) {
        HashMap<String, List<Apple>> map = new HashMap<>();
        list.stream().forEach(a -> {
            List<Apple> apples = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> apple = new ArrayList<>();
                map.put(a.getColor(), apple);
                return apple;
            });
            apples.add(a);
        });
        return map;
    }

    //按照颜色将苹果分组
    public static Map<String,List<Apple>> getAppleByColorGroup(List<Apple> list) {
        HashMap<String, List<Apple>> map = new HashMap<>();
        for(Apple apple : list) {
            List<Apple> apples = map.get(apple.getColor());
            if(null == apples) {
                apples = new ArrayList<>();
                map.put(apple.getColor(), apples);
            }
            apples.add(apple);
        }
        return map;
    }
}
