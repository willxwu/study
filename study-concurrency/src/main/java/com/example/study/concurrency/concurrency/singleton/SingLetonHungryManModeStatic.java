package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.ThreadSafety;

/**
 * @description: 单例-饿汉模式，静态代码写法
 * 注意：静态代码和静态域的顺序，不然会导致空指针
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 22:20
 * @version: 1.0
 */
@ThreadSafety
public class SingLetonHungryManModeStatic {

    private SingLetonHungryManModeStatic() {}

    //静态作用域
    private static SingLetonHungryManModeStatic instance = null;

    //静态代码块
    static{
        instance = new SingLetonHungryManModeStatic();
    }

    public static SingLetonHungryManModeStatic getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
