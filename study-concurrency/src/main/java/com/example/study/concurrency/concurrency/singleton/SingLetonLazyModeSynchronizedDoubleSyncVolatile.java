package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.ThreadSafety;

/**
 * @description: 单例-懒汉模式（volatile+双重检测机制单列） 线程安全
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 22:05
 * @version: 1.0
 */
@ThreadSafety
public class SingLetonLazyModeSynchronizedDoubleSyncVolatile {

    //私有构造方法
    private SingLetonLazyModeSynchronizedDoubleSyncVolatile() {}

    //实例对象
    //volatile禁止指令重排
    private volatile static SingLetonLazyModeSynchronizedDoubleSyncVolatile instance = null;

    //静态工厂方法
    public static SingLetonLazyModeSynchronizedDoubleSyncVolatile getInstance() {

        if (null == instance) { //双重检测机制
            synchronized (SingLetonLazyModeSynchronizedDoubleSyncVolatile.class) { //同步锁
                if (null == instance) {
                    instance = new SingLetonLazyModeSynchronizedDoubleSyncVolatile();
                }
            }
        }
        return instance;
    }
}
