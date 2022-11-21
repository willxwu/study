package com.example.study.java8.completableFutures;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture 基本用法
 */
public class CompletableFutureInAction1 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //实际开发中，一般不直接new，而是使用工厂创建
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync();

        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            double value = get();
            completableFuture.complete(value);
        }).start();

        //不会阻塞程序执行
        System.out.println("===========no====block====..");
        //1、后面获取程序执行结果
//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
        //2、执行完后，通过回调自动返回结果
        completableFuture.whenComplete((v,t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
        });
    }

    static double get(){
        try {
            Thread.sleep(RANDOM.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = RANDOM.nextDouble();
        System.out.println(value);
        return value;
    }
}
