package com.example.study.vip.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建线程
 */
public class CreateExcuters06 {
    public static void main(String[] args) {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());

        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
//            }
//        });

        executorService.execute(()->System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName()));
    }
}
