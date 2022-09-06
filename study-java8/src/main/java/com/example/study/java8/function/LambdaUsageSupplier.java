package com.example.study.java8.function;

import java.util.function.Supplier;

/**
 * Lamdba表达式之Supplier用法
 */
public class LambdaUsageSupplier {
    public static void main(String[] args) {

        //范例1
        Supplier<String> stringSuppier = String::new;
        System.out.println(stringSuppier.get().getClass());

        System.out.println("=====================");

        //范例2
        Apple apple = createApple(() -> {
            return new Apple("五颜六色", 200);
        });
        System.out.println(apple.toString());
    }

    public static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }
}
