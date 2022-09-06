package com.example.study.java8.InterfaceFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * Lambda表达式：Funcation用法
 */
public class LambdaUsageFuncation {
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

        //1、2个参数调用
        List<String> stringsUsageFuncation = simpleUsageFuncation(list, apple -> apple.getColor() + ":颜色");
        for(String color: stringsUsageFuncation){
            System.out.println(color);
        }

        System.out.println("============================");

        //2、其它用法IntFuncation调用
        List<Integer> integerList = intUsageFuncation(list, weight-> weight*20);
        for(Integer i : integerList){
            System.out.println(i);
        }

        System.out.println("==============================");
        //3、3个参数调用
        Apple newApple = threeeUsageFuncation("彩色", 178, (newColor, newInteger) -> {
            return  new Apple(newColor, newInteger);
        });
        System.out.println(newApple.toString());
    }

    //1、2个参数 简单用法
    public static List<String> simpleUsageFuncation(List<Apple> source, Function<Apple, String> function){
        List<String > result = new ArrayList<>();
        for(Apple apple:source){
            result.add(function.apply(apple));
        }
        return result;
    }

    //2、其它用法IntFuncation
    public static List<Integer> intUsageFuncation(List<Apple> source, IntFunction<Integer> function){
        List<Integer > result = new ArrayList<>();
        for(Apple apple:source){
            result.add(function.apply(apple.getWeight()));
        }
        return result;
    }

    //3、3个参数用法
    public static  Apple threeeUsageFuncation(String newColor, Integer newWeight, BiFunction<String, Integer, Apple> biFunction){
        return biFunction.apply(newColor, newWeight);
    }

}
