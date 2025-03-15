package com.example.study.vip.thread;

import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

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

    /**
     * 直接返回结果，异步未执行完，主线程拿不到返回结果
     * @return
     */
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

    @Async
    public CompletableFuture<String> AsyncTestMethod3(){
        System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
            System.out.println("我是子线程,执行中，子线程名:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是子线程,执行结束，子线程名:"+Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Hello world");
    }


}
