package com.example.study.java8.collector;

import com.example.study.java8.streams.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.example.study.java8.collector.CollectorsAction.menu;

/**
 * Collector groupingByConcurrent 分组
 */
public class CollectorsAction2 {

    public static void main(String[] args) {
        testGroupingByConcurrentWithFunction();
        testGroupingByConcurrentWithFunctionAndCollector();
        testGroupingByConcurrentWithFunctionAndSupplierAndCollector();
        testJoin();
        testJoinWithDelimiter();
        testJoinWithDelimiterAndPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }

    //groupingByConcurrent  返回map为ConcurrentMap,按类型分组
    public static void testGroupingByConcurrentWithFunction() {
        System.out.println("testGroupingByConcurrentWithFunction");
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //groupingByConcurrent  返回map为ConcurrentMap,按按类型分组，并求平均值
    public static void testGroupingByConcurrentWithFunctionAndCollector() {
        System.out.println("testGroupingByConcurrentWithFunctionAndCollector");
        Map<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //groupingByConcurrent  返回map为ConcurrentMap,按按类型分组，并求平均值,并修改返回类型为ConcurrentSkipListMap(跳表，以空间换时间的数据结构)
    public static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector() {
        System.out.println("testGroupingByConcurrentWithFunctionAndSupplierAndCollector");
        ConcurrentSkipListMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //joining 拼接，不能直接join
    public static void testJoin() {
        System.out.println("testJoin");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //joining 拼接,通过逗号拼接
    public static void testJoinWithDelimiter() {
        System.out.println("testJoinWithDelimter");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //joining 拼接,通过逗号拼接,拼接后加前缀和后
    public static void testJoinWithDelimiterAndPrefixAndSuffix() {
        System.out.println("testJoinWithDelimiterAndPrefixAndSuffix");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(",","Names:[","]"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //mapping 拼接，能直接join
    public static void testMapping() {
        System.out.println("testMapping");
        String collect = menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //maxBy 查找最大的一个Dish
    public static void testMaxBy() {
        System.out.println("testMaxBy");
        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }

    //minBy 查找最小的一个Dish
    public static void testMinBy() {
        System.out.println("testMinBy");
        Optional<Dish> collect = menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }

}
