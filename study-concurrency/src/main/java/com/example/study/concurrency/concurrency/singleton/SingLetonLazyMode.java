package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.UnThreadSafety;

/**
 * @description: 单例-懒汉模式
 * 在第一次使用时创建
 * 单线程下没问题，多线程下可能出现问题
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 22:05
 * @version: 1.0
 */
@UnThreadSafety
public class SingLetonLazyMode {

    //私有构造方法
    private SingLetonLazyMode() {}
    //实例对象
    private static SingLetonLazyMode instance = null;

    //静态工厂方法
    public static SingLetonLazyMode getInstance() {
        //注意：多线程下问题，当2个线程同时判断到不为null，是都会调用私有构造方法，创建2个示例对象。
        // 如果在构造方法中有对环境一些设置，2次执行会出现一些错误
        if (null == instance) {
            instance = new SingLetonLazyMode();
        }
        return instance;
    }
}
