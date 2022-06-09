package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.UnThreadSafety;

/**
 * @description: 单例-懒汉模式（双重同步锁单例）
 * 线程不安全
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 22:05
 * @version: 1.0
 */
@UnThreadSafety
public class SingLetonLazyModeSynchronized {

    //私有构造方法
    private SingLetonLazyModeSynchronized() {}
    //实例对象
    private static SingLetonLazyModeSynchronized instance = null;

    //静态工厂方法
    public static SingLetonLazyModeSynchronized getInstance() {

        if (null == instance) { //双重检测机制
            //当第一个线程执行后，已经实例化一个对象了，第二个线程再次判断兑现是否实例。
            //线程不安全问题所在：
            //
            synchronized(SingLetonLazyModeSynchronized.class) { //同步锁
                if(null == instance) {
                    instance = new SingLetonLazyModeSynchronized();
                }
            }
        }
        return instance;
    }
}
