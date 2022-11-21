package com.example.study.java8.completableFutures;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureInAction3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            return thread;
        });
        CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executorService)
                .thenApply(CompletableFutureInAction3::multply)
                .whenComplete((v, t) -> Optional.ofNullable(v).ifPresent(System.out::println));

    }

    private static Double multply(Double value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value * 10D;
    }
}
