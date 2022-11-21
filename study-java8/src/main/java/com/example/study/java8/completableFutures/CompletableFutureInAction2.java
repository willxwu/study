package com.example.study.java8.completableFutures;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompletableFutureInAction2 {
    public static void main(String[] args) throws InterruptedException {

/*        AtomicBoolean finished = new AtomicBoolean(false);
        CompletableFuture.supplyAsync(CompletableFutureInAction1::get)
                .whenComplete((v, t) -> {
                    Optional.ofNullable(v).ifPresent(System.out::println);
                    Optional.ofNullable(t).ifPresent(x -> t.printStackTrace());
                    finished.set(true);
                });

        System.out.println("======no====block===");
        //添加这个目的是为了解决，主线程结束后守护线程也结束了。这里判断守护线程是否执行完毕，没执行完就休眠一会。
        while(!finished.get()) {
            Thread.sleep(1);
        }*/


/*
        //这里不是守护线程不会自动结束线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            System.out.println("===test====");
        });
        executorService.shutdown();
*/

        ExecutorService executorService = Executors.newFixedThreadPool(2, r -> {
            Thread t = new Thread(r);
            t.setDaemon(false);
//            t.setDaemon(true);
            return t;
        });
        // //添加这个目的是为了解决，主线程结束后守护线程也结束了。
        CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executorService)
                .whenComplete((v, t) -> {
                    Optional.ofNullable(v).ifPresent(System.out::println);
                    Optional.ofNullable(t).ifPresent(x -> t.printStackTrace());
                });

        System.out.println("======no====block===");
    }
}
