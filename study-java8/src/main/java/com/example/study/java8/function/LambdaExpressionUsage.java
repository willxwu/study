package com.example.study.java8.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda语法：
 * 参数列表            lambda body部分
 * (o1,o2)->o1.getWeight().compareTo(o2.getWeight());
 * <p>
 * 合法lamdba表达式：
 * 1、s -> s.length();  或者 (String s) -> s.length();
 * 2、apple -> apple.getColor().equals("great"); 或者 (Apple apple) -> apple.getColor().equals("great");
 * 3、(int x, int y) -> {
 *      System.out.println(x);
 *      System.out.println(y);
 * };
 * 4、() -> 12;
 * 5、()-{};
 * 6、()->“hello” 或者 ()->{return "hello"}
 * <p>
 * 语法总结：
 * 1、（参数列表） -> 表达式
 * 2、（参数列表） -> {语句;}
 * 3、() -> {}
 * 4、() -> "hello" 或者 ()->{reurn "hello"}
 * 5、(String str) -> {return "hello"} 或者 (String str) -> "hello";
 * <p>
 * 无效lambda表达式
 * (integer i)->{return "错误示范"+i}
 */
public class LambdaExpressionUsage {
    public static void main(String[] args) {
        Comparator<Apple> colorComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> apples = Arrays.asList(new Apple("a", 18), new Apple("c", 20), new Apple("b", 10));
        for (Apple a : apples) {
            System.out.println(a.toString());
        }

        System.out.println("=================================");


        apples.sort(colorComparator);

        for (Apple a : apples) {
            System.out.println(a.toString());
        }

        System.out.println("=================================");
        //lambda expression
        //方法推导：接口有返回值时，注意lambda有大括号{}，必须要有return，没有可以不用使用return关键词
        //1、有{},必须使用return
        Comparator<Apple> weightComparator = (o1, o2) -> {
            return o1.getWeight().compareTo(o2.getWeight());
        };
        //2、不使用{}，没有return
        Comparator<Apple> weightComparator2 = (o1, o2) -> o1.getWeight().compareTo(o2.getWeight());

        apples.sort(weightComparator);

        for (Apple a : apples) {
            System.out.println(a.toString());
        }

        //合法lambda表达式格式1
        Function<String, Integer> stringIntegerFunction = s -> s.length();

        //合法lambda表达式格式2
        Predicate<Apple> great = (Apple apple) -> apple.getColor().equals("great");
        Predicate<Apple> great2 = apple -> apple.getColor().equals("great");

        //合法lambda表达式格式3
//        (int x, int y) -> {
//            System.out.println(x);
//            System.out.println(y);
//        };

        //合法lambda表达式格式4
        Callable<Integer> integerCallable = () -> 12;

        //合法lambda表达式格式5
        Runnable runnable = () -> {

        };

        //合法lambda表达式格式6
        Callable<String> stringCallable = () -> "hello";

        //合法lambda表达式格式7
        Function<String, String> stringStringFunction = (String str) -> {
            return "hello";
        };

        //合法lambda表达式格式8
        Function<String, String> stringStringFunction1 = (String str) -> "hello";


        //Funcation有返回参数类型
        //1、返回Boolean类型
        Function<Apple, Boolean> boolearnFunction = apple -> apple.getColor().equals("red");
        //2、返回String类型
        Function<Apple, String> stringFunction = apple -> apple.getColor();
        //3、返回Integer类型
        Function<Apple, Integer> integerFunction = apple -> apple.getWeight();
        //4、。。。等等其它类型同理

        //Consumer无参数返回类型
        Consumer<Apple> appleConsumer = apple -> System.out.println(apple.getColor());
        Consumer<Apple> appleConsumer2 = apple -> System.out.println("hello");

        //Predicate返回Boolean类型（判断类型）
        Predicate<Apple> colorPredicate = apple -> apple.getColor().equals("red");
        Predicate<Apple> weightPredicate = apple -> apple.getWeight()==4;

        System.out.println("=============");
        //Supplier获取对象
        Supplier<Apple> appleSupplier = Apple::new;
        System.out.println(appleSupplier.get());
    }

}
