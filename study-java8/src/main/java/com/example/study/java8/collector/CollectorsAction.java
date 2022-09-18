package com.example.study.java8.collector;

import com.example.study.java8.streams.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * collecotr  聚合，计算
 */
public class CollectorsAction {
    public static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
//        testAveragingDouble();
//        testAveragingInt();
//        testAveragingLong();
//        testCollectingAndThen();
//        testCounting();
        testGroupingByFunction();
        testGroupingByFunctionAndCollector();
        testGroupingByFunctionAndSuppilerAndCollector();
    }

    //1、averagingDouble  求平均值
    public static void testAveragingDouble(){
        System.out.println("testAveragingDouble");
        //用reduce聚合求和
        Optional.ofNullable(menu.stream().map(Dish::getCalories).reduce(Integer::sum)).get().ifPresent(System.out::println);
        //用collectors averagingDouble求平均值
        Optional.ofNullable(menu.stream().collect(averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }
    //2、averagingInt  求平均值
    public static void testAveragingInt(){
        System.out.println("testAveragingInt");
        //用collectors averagingDouble求平均值
        Optional.ofNullable(menu.stream().collect(averagingInt(Dish::getCalories))).ifPresent(System.out::println);
    }
    //3、averagingLong  求平均值
    public static void testAveragingLong(){
        System.out.println("testAveragingLong");
        //用collectors averagingLong求平均值
        Optional.ofNullable(menu.stream().collect(averagingLong(Dish::getCalories))).ifPresent(System.out::println);
    }


    //4、collectingAndThen(收集数据，处理数据)，将搜集结果，再做处理。
    public static void testCollectingAndThen(){
        System.out.println("testCollectingAndThen");
        //1、CollectingAndThen  求平均数后，拼接一句话
        Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(averagingInt(Dish::getCalories),a->"This is Calories eques = "+a))).ifPresent(System.out::println);


        //获取MEAT类，之后再往里面加入其它类型
        List<Dish> collect = menu.stream().filter(m -> Dish.Type.MEAT.equals(m.getType())).collect(toList());
        collect.add(new Dish("回锅肉", true, 550, Dish.Type.OTHER));
        collect.stream().forEach(System.out::println);

        //2、CollectingAndThen 如果想将收集结果设置为不可修改
        List<Dish> meatCollect = menu.stream().filter(m -> Dish.Type.MEAT.equals(m.getType())).collect(collectingAndThen(toList(), Collections::unmodifiableList));
        //修改时就会报错：Exception in thread "main" java.lang.UnsupportedOperationException
        meatCollect.add(new Dish("回锅肉", true, 550, Dish.Type.OTHER));
        collect.stream().forEach(System.out::println);
    }



    //5、counting   统计 返回Long类型
    public static void testCounting(){
        System.out.println("testCounting");
        Optional.ofNullable(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    //6、groupingBy  分组
    public static void testGroupingByFunction(){
        System.out.println("testGroupingByFunction");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);
    }

    //groupingBy  分组后统计
    public static void testGroupingByFunctionAndCollector(){
        System.out.println("testGroupingByFunctionAndCollector");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType,counting()))).ifPresent(System.out::println);
    }

    //groupingBy  分组后求平均值，默认是HashMap,通过groupingBy修改返回类型
    public static void testGroupingByFunctionAndSuppilerAndCollector(){
        System.out.println("testGroupingByFunctionAndSuppilerAndCollector");
        Map<Dish.Type, Double> map = Optional.of(menu.stream().collect(groupingBy(Dish::getType, averagingInt(Dish::getCalories)))).get();
        //默认是返回HashMap类型
        Optional.ofNullable(map.getClass()).ifPresent(System.out::println);

        TreeMap<Dish.Type, Double> newMap = Optional.of(menu.stream().collect(groupingBy(Dish::getType, TreeMap::new, averagingInt(Dish::getCalories)))).get();
        //groupingBy:修改返回类型为TreeMap
        Optional.ofNullable(newMap.getClass()).ifPresent(System.out::println);
    }
}
