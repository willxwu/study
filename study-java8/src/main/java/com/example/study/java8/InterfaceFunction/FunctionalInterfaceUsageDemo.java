package com.example.study.java8.InterfaceFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 函数式接口使用Demo入门
 */
public class FunctionalInterfaceUsageDemo {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("red",100), new Apple("great",150));

        List<Apple> greats = findApple(list, apple -> {
            return apple.getColor().equals("great");
        });
        assert greats.size()==1;
        System.out.println(greats);

//        new Thread(()->System.out.println(Thread.currentThread().getName())).start();
        
    }

    public static List<Apple> findApple(List<Apple> apples, FunctionalInterfaceDemo functionalInterfaceDemo){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : apples) {
            if(functionalInterfaceDemo.colorFilter(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
