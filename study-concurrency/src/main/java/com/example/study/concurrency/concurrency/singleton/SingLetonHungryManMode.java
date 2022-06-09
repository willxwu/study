package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.ThreadSafety;

/**
 * @description: 单例-饿汉模式
 * 类装载时创建，线程安全的
 * 不足： 1、如果私有构造方法里面有过多的设置，会加载很慢
 *       2、每次都会创建示例对象，造成资源浪费
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 22:20
 * @version: 1.0
 */
@ThreadSafety
public class SingLetonHungryManMode {

    private SingLetonHungryManMode() {}

    private static SingLetonHungryManMode instance = new SingLetonHungryManMode();

    public static SingLetonHungryManMode getInstance() {
        return instance;
    }
}
