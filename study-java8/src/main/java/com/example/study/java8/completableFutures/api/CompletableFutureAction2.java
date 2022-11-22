package com.example.study.java8.completableFutures.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class CompletableFutureAction2 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {
/*        //API-- 1、runAfterBoth: 2个都执行完后,再执行其它操作
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "this is runing 1......");
            return 1;
        })
        .runAfterBoth(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "this is runing 2......");
            return 2;
        }), () -> System.out.println("done"));*/



/*        //API-- 2、applyToEither: 其中一个CompletableFuture执行完，就将结果传递到另一个Function中。
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"this is one future...");
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"this is two future...");
            return 2;
        }), v->
            10 * v
        ).thenAccept(System.out::println);*/



        /*//API-- 3、acceptEither: 其中一个CompletableFuture执行完，就将结果传递到另一个Function中。
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"this is one future...");
            return 1;
        }).acceptEither(CompletableFuture.supplyAsync(()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"this is two future...");
                    return 2;
                }), System.out::println
        );*/



/*
        //API-- 4、runAfterEither: 其中一个CompletableFuture执行完，就可以做其它操作了。不会将结果传递，可以做类似其中一个操作完后的消息通知功能。
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"this is one future...");
            return 1;
        }).runAfterEither(CompletableFuture.supplyAsync(()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"this is two future...");
                    return 2;
                }),()-> System.out.println("其中一个future执行完成")
        );
*/



/*        //API-- 5、allOf: 静态方法，可直接调用。全部future执行完后，再进行消费
        List<CompletableFuture<Double>> completableFutureList = Arrays.asList(1, 2, 3, 4, 5)
                .stream().map(i -> CompletableFuture.supplyAsync((CompletableFutureAction2::get)))
                .collect(toList());

        CompletableFuture[] completableFuturesArray = completableFutureList.toArray(new CompletableFuture[completableFutureList.size()]);

        CompletableFuture.allOf(completableFuturesArray).thenRun(()-> System.out.println("所有future执行完成"));*/



        //API-- 6、anyOf: 静态方法，可直接调用。其中一个future执行完后，就进行消费
        List<CompletableFuture<Double>> futureList = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(i -> CompletableFuture.supplyAsync(CompletableFutureAction2::get))
                .collect(toList());

        CompletableFuture[] futuresArray = futureList.toArray(new CompletableFuture[futureList.size()]);

        CompletableFuture.anyOf(futuresArray).thenRun(()-> System.out.println("其中一个future已执行完成"));




        //为了防止主线程结束后，守护线程被关闭，模拟修改10000毫秒
        Thread.sleep(50000);
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
