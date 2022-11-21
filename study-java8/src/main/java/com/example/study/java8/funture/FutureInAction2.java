package com.example.study.java8.funture;

import java.util.List;
import java.util.concurrent.*;

/**
 * 和自定义Future中block一样会卡住
 */
public class FutureInAction2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //创建一个单线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //返回一个future，里面的操作可能还没完成，但不影响后续的操作。
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
                return "I'm finished";
            } catch (InterruptedException e) {
                return "I'm error";
            }
        });
        //没有结果会抛出，中断异常
//        String value = future.get();
        //最后等10秒没拿到，就抛出异常。
//        String value = future.get(10, TimeUnit.MICROSECONDS);
        //判断future里面线程是否执行完成，没有执行完成，则继续等待10秒。
        while(!future.isDone()){
            Thread.sleep(10);
        }
        //最后执行完成，直接可以拿到结果
        System.out.println(future.get());
        //关闭进程
        executorService.shutdown();

        //shutdownNow关闭进程，但是会返回有那些进程还没有执行完。
        List<Runnable> runnables = executorService.shutdownNow();
    }
}
