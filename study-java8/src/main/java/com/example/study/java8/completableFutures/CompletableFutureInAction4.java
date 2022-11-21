package com.example.study.java8.completableFutures;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 根据商品id，将每个商品价格翻2倍。CompletableFuture高并发执行。
 */
public class CompletableFutureInAction4 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //防止主线程执行完后，守护线程也关闭
        ExecutorService executorService = Executors.newFixedThreadPool(2, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            return thread;
        });

        //5个商品ID
        List<Integer> productIDs = Arrays.asList(1, 2, 3, 4, 5);
        //通过CompletableFuture查询5个商品价格
        Stream<CompletableFuture<Double>> completableFutureStream = productIDs.stream().map(i -> CompletableFuture.supplyAsync(() -> queryProduct(i), executorService));
        //将每个商品价格翻2倍
        Stream<CompletableFuture<Double>> multplyFutures = completableFutureStream.map(future -> future.thenApply(CompletableFutureInAction4::multply));
        //将翻倍后的CompletableFuture加入线程中，将翻倍后价格收集成一个list数组
        List<Double> result = multplyFutures.map(CompletableFuture::join).collect(toList());
        //输出最后翻倍价格
        System.out.println(result);
    }

    private static Double multply(Double value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value * 2D;
    }

    private static Double queryProduct(int i){
        return CompletableFutureInAction4.get();
    }

    //模拟从数据库根据商品ID查询价格
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
