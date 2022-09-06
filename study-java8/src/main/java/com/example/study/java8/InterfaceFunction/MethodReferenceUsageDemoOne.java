package com.example.study.java8.InterfaceFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法推导
 * 什么情况下可以进行方法推导：
 * 1、类的方法（静态方法）
 * 2、对象的方法
 * 3、构造方法
 */
public class MethodReferenceUsageDemoOne {
    public static void main(String[] args) {
        //方法推导，范例一：类的方法
        //原始写法
        Consumer<String> consumer = s-> System.out.println(s);
        genericityConsumer(consumer, "hello");

        //1、进化一
        genericityConsumer(s->System.out.println(s), "world");
        //2、进化二
        genericityConsumer(System.out::println, "nice");


        System.out.println("===========================");
        //方法推导，范例二：类的方法

        List<Apple> list = Arrays.asList(new Apple("red", 10)
                , new Apple("red", 60)
                , new Apple("blue", 40)
                , new Apple("black", 30)
                , new Apple("green", 80)
                , new Apple("blue", 90)
                , new Apple("green", 60)
                , new Apple("green", 50)
                , new Apple("red", 20));
        System.out.println(list);

        list.sort((oneParameter,twoParameter)->oneParameter.getColor().compareTo(twoParameter.getColor()));
        System.out.println(list);

        System.out.println("============排序另一种写法===============");
        //排序另一种写法
        List<Apple> list2= Arrays.asList(new Apple("red", 10)
                , new Apple("red", 60)
                , new Apple("blue", 40)
                , new Apple("black", 30)
                , new Apple("green", 80)
                , new Apple("blue", 90)
                , new Apple("green", 60)
                , new Apple("green", 50)
                , new Apple("red", 20));
        System.out.println(list2);
        list2.sort(Comparator.comparing(Apple::getColor));

        //排序说明：
        //1、匿名内部类
        //2、上面第一种写法
        //3、上面第二种写法
        //代码越来越简单



        System.out.println("===========================");
        //方法推导，范例三：类的方法
        //原始写法
        list.stream().forEach(apple->System.out.println(apple));

        System.out.println("===========================");
        //进化1
        list.stream().forEach(System.out::println);


        System.out.println("===========================");
        //方法推导，范例四：类的方法
        //原始写法
        Integer integer = Integer.parseInt("123");
        System.out.println(integer);
        System.out.println("===========================");
        //进化
        Function<String, Integer> function = Integer::parseInt;
        Integer integerTwo = function.apply("321");
        System.out.println(integerTwo);


        System.out.println("===========================");
        //方法推导，范例五：对象的方法
        BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
        Character character = stringIntegerCharacterBiFunction.apply("Hello", 1);
        System.out.println(character);



        System.out.println("===========================");
        //方法推导，范例六：构造方法,1个参数
        Supplier<String> supplier = String::new;
        String str = supplier.get();
        System.out.println(str.getClass());

        System.out.println("===========================");
        //方法推导，范例七：构造方法,2个参数
        //说明：Apple::new; 就是掉构造方法，自动推导参数和类型
        BiFunction<String,Integer,Apple> appleBiFunction = Apple::new;
        Apple apple = appleBiFunction.apply("red", 50);
        System.out.println(apple);

        System.out.println("===========================");
        //方法推导，范例八：构造方法-自定义FunctionalInterface接口,多个参数
        CustomThreeFunctionalInterface<String,Integer,String,ComplexApple> appleSupplier = ComplexApple::new;
        ComplexApple complexApple = appleSupplier.apply("苹果",20,"green");
        System.out.println(complexApple);

    }

    /**
     * 泛型Consumer
     * @param consumer
     * @param t
     * @param <T>
     */
    public static <T> void genericityConsumer(Consumer<T> consumer, T t){
        consumer.accept(t);
    }
}
