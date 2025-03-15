package com.example.study.vip.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口实现，是阻塞线程，需要等带子线程执行完后返回结果，主线程才会继续往下执行
 */
public class CreateFuntrueTask05 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("我是子线程,开始执行,子线程名:"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
        }catch (Exception e){

        }
        System.out.println("我是子线程,子线程执行结束,子线程名:"+Thread.currentThread().getName());
        return "Hello World";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("我是主线程,开始执行,线程名:"+Thread.currentThread().getName());

        FutureTask<String> futureTask = new FutureTask<>(new CreateFuntrueTask05());
        new Thread(futureTask).start();
        System.out.println("我是主线程,在等待子线程执行,等待后去结果,线程名:"+Thread.currentThread().getName());

        String say = futureTask.get();

        System.out.println("我是主线程,获取到子线程结果:"+say+" 线程名:"+Thread.currentThread().getName());

        System.out.println("我是主线程,执行结束,线程名:"+Thread.currentThread().getName());
    }
}
