package com.example.study.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Lambda表达式：Consumer用法
 */
public class LambdaUasgeConsumer {
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


        //1个参数调用
        simpleUsageConsumer(list, apple -> System.out.println(apple.toString()));

        System.out.println("========================");
        twoArgsUsageConsumer("我买了水果",list, (apple, name)->{
            System.out.println(name+",颜色:"+apple.getColor()+"\t 重量:"+apple.getWeight());
        });
    }

    //1、一个参数用法
    public static void simpleUsageConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    //2、两个参数用法
    public static void twoArgsUsageConsumer(String name, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, name);
        }
    }
}
