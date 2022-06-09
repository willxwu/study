package com.example.study.concurrency.concurrency.singleton;


import com.example.study.concurrency.concurrency.annotation.Recommend;
import com.example.study.concurrency.concurrency.annotation.ThreadSafety;

/**
 * @description: 单例-枚举模式，线程最安全的,推荐使用的
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 23:11
 * @version: 1.0
 */
@ThreadSafety
@Recommend
public class SingLetonEnum {
    //私有构造方法
    private SingLetonEnum() {};

    public static SingLetonEnum getInstance() {
        return SingLeton.INSTANCE.getSingLetonEnum();
    };

    private enum SingLeton {
        INSTANCE;

        private SingLetonEnum singLetonEnum;

        //JVM保证这个方法绝对只会被执行一次
        SingLeton(){
            singLetonEnum = new SingLetonEnum();
        }

        public SingLetonEnum getSingLetonEnum() {
            return singLetonEnum;
        }
    }
}
