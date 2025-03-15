package com.example.study.vip.thread;

import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步注解
 */
@Component
public class CreateAsync07 {

    public void AsyncTestMethod(){
        System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
            System.out.println("我是子线程,执行中，子线程名:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是子线程,执行结束，子线程名:"+Thread.currentThread().getName());
    }

    @Async
    public String AsyncTestMethod2(){
        System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
            System.out.println("我是子线程,执行中，子线程名:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是子线程,执行结束，子线程名:"+Thread.currentThread().getName());
        return "Hello world";
    }
}
