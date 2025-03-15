package com.example.study.vip.thread.controller;

import com.example.study.vip.thread.CreateAsync07;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class FindController {
    @Autowired
    private CreateAsync07 createAsync07;

    @GetMapping("/f")
    public String say(){
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        createAsync07.AsyncTestMethod();
        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    @GetMapping("/f2")
    public String say2(){
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                createAsync07.AsyncTestMethod();
            }
        });

        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    @GetMapping("/f3")
    public String say3(){
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        createAsync07.AsyncTestMethod2();
        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }
}
