package com.example.study.java8.collector;

import com.example.study.java8.streams.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.example.study.java8.collector.CollectorsAction.menu;

/**
 * JAVA8-Collectors API: partitioningBy、reducing、summarizingLong、summarizingInt、summarizingDouble
 */
public class CollectorsAction3 {
    public static void main(String[] args) {
//        testPartitioningByWithPredicate();
//        testPartitioningByWithPredicateAndCollecotr();
//        testReducingBinaryOperator();
//        testReducingBinaryOperatorAndIdentity();
//        testReducingBinaryOperatorAndIdentityAndFunction();
//        testSummarizingDouble();
//        testSummarizingInt();
        testSummarizingLong();
    }

    //1、partitioningBy 分组
    public static void testPartitioningByWithPredicate() {
        System.out.println("testPartitioningByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //2、partitioningBy 分组后，再处理求平均数
    public static void testPartitioningByWithPredicateAndCollecotr() {
        System.out.println("testPartitioningByWithPredicateAndCollecotr");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    //3、reducing
    public static void testReducingBinaryOperator() {
        System.out.println("testReducingBinaryOperator");
        Optional<Dish> collect = menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        collect.ifPresent(System.out::println);
    }

    //4、reducing
    public static void testReducingBinaryOperatorAndIdentity() {
        System.out.println("testReducingBinaryOperatorAndIdentity");
        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    //5、reducing
    public static void testReducingBinaryOperatorAndIdentityAndFunction() {
        System.out.println("testReducingBinaryOperatorAndIdentityAndFunction");
        Integer collect = menu.stream().collect(Collectors.reducing(0, Dish::getCalories,(d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    //6、summarizingDouble
    public static void testSummarizingDouble() {
        System.out.println("testSummarizingDouble");
        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //7、summarizingInt
    public static void testSummarizingInt() {
        System.out.println("testSummarizingDouble");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //8、summarizingLong
    public static void testSummarizingLong() {
        System.out.println("testSummarizingLong");
        LongSummaryStatistics collect = menu.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

}
