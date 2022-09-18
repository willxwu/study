package com.example.study.java8.collector;

import com.example.study.java8.streams.Dish;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.example.study.java8.collector.CollectorsAction.menu;

/**
 * JAVA8-Collectors API:summingDouble、summingInt、testSummingLong、toCollection、toConcurrentMap、toList、toSet、toMap
 */
public class CollectorsAction4 {
    public static void main(String[] args) {
//        testSummingDouble();
//        testSummingInt();
//        testSummingLong();
//        testToCollection();
//        testToConcurrentMap();
//        testToConcurrentMapWithBinaryOperator();
//        testToConcurrentMapWithBinaryOperatorAndSupplier();
//        testTolist();
//        testToSet();
//        testToMap();
//        testToMapWithBinaryOperator();
        testToMapWithBinaryOperatorAndSupplier();
    }

    //1、summingDouble
    public static void testSummingDouble() {
        System.out.println("testSummingDouble");
        Optional.ofNullable(menu.stream().collect(Collectors.summingDouble(Dish::getCalories))).ifPresent(System.out::println);
        //其它api也可以实现
        Optional.ofNullable(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum()).ifPresent(System.out::println);
    }

    //2、summingDouble
    public static void testSummingInt() {
        System.out.println("testSummingInt");
        Optional.ofNullable(menu.stream().collect(Collectors.summingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    //3、summingLong
    public static void testSummingLong() {
        System.out.println("testSummingLong");
        Optional.ofNullable(menu.stream().collect(Collectors.summingLong(Dish::getCalories))).ifPresent(System.out::println);
    }

    //4、toCollection 返回Collection子类
    public static void testToCollection() {
        System.out.println("testToCollection");
        Optional.ofNullable(menu.stream().collect(Collectors.toCollection(LinkedList::new))).ifPresent(System.out::println);
    }

    //5、toConcurrentMap
    public static void testToConcurrentMap() {
        System.out.println("testToConcurrentMap");
        Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getName,Dish::getCalories))).ifPresent(System.out::println);
    }

    //6、toConcurrentMap 按类型统计个数
    public static void testToConcurrentMapWithBinaryOperator() {
        System.out.println("testToConcurrentMapWithBinaryOperator");
        Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType,v->1L,(a,b)->a+b))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //7、toConcurrentMap 按类型统计个数，返回指定类型Map
    public static void testToConcurrentMapWithBinaryOperatorAndSupplier() {
        System.out.println("testToConcurrentMapWithBinaryOperatorAndSupplier");
        Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType,v->1L,(a,b)->a+b, ConcurrentSkipListMap::new))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //8、toList 转成list
    public static void testTolist() {
        System.out.println("testTolist");
        Optional.ofNullable(menu.stream().filter(t->t.isVegetarian()).collect(Collectors.toList())).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //9、toSett 转成Set
    public static void testToSet() {
        System.out.println("testToSet");
        Optional.ofNullable(menu.stream().filter(t->t.isVegetarian()).collect(Collectors.toSet())).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //10、toMap
    public static void testToMap() {
        System.out.println("testToMap");
        Optional.ofNullable(menu.stream().collect(Collectors.toMap(Dish::getName,Dish::getCalories))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });

        //转成线程安全的map
        Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.toMap(Dish::getName, Dish::getCalories), Collections::synchronizedMap))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //11、toMap 按类型统计个数
    public static void testToMapWithBinaryOperator() {
        System.out.println("testToMapWithBinaryOperator");
        Optional.ofNullable(menu.stream().collect(Collectors.toMap(Dish::getType,v->1L,(a,b)->a+b))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

    //12、toMap 按类型统计个数，返回指定类型Map
    public static void testToMapWithBinaryOperatorAndSupplier() {
        System.out.println("testToMapWithBinaryOperatorAndSupplier");
        Optional.ofNullable(menu.stream().collect(Collectors.toMap(Dish::getType,v->1L,(a,b)->a+b, ConcurrentSkipListMap::new))).ifPresent(v->{
            System.out.println(v);
            System.out.println(v.getClass());
        });
    }

}
