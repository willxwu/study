package com.example.study.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Lambda表达式的使用:Prodicate用法
 */
public class LambdaUsagePredicate {
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

        //Predicate用法
        List<Apple> filterList = filter(list, apple -> apple.getColor().equals("green"));

        for (Apple apple : filterList) {
            System.out.println(apple.toString());
        }

        System.out.println("============================");


        //其它类似Predicate用法
        //IntegerPredicate用法
        List<Apple> filterByWeight = predicateByWeight(list, weight -> weight == 60);
        for (Apple apple : filterByWeight) {
            System.out.println(apple.toString());
        }


        System.out.println("============================");

        //BiPredicate用法
        List<Apple> biPredicateResult = biPredicateByColorAndWeight(list, (color, weight) -> {
            return color.equals("green") && weight == 60;
        });
        for (Apple apple : biPredicateResult) {
            System.out.println(apple.toString());
        }
    }


    //1、Predicate：诊断的用法
    public static List<Apple> filter(List<Apple> sources, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : sources) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    //2、其它类似Predicate用法
    //IntegerPredicate用法
    public static List<Apple> predicateByWeight(List<Apple> source, IntPredicate intPredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (intPredicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    //3、带2个参数的BiPredicate用法
    public static List<Apple> biPredicateByColorAndWeight(List<Apple> source, BiPredicate<String, Integer> biPredicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : source) {
            if (biPredicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }
}
