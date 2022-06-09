package com.example.study.concurrency.concurrency.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description: 结果，最后只会执行一次
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 22:05
 * @version: 1.0
 */
@Slf4j
public class DemoAtomicBoolean {

    private static AtomicBoolean isHappen = new AtomicBoolean(false);

    //用户数量
    private static final int clientsTotal = 5000;
    //并发数量
    private static final int concurrencyTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(clientsTotal);
        //闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(concurrencyTotal);

        for (int i = 0; i < clientsTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("出现错误:【{}】", e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappen结果为count=【{}】",isHappen.get());
    }

    public static void test() {
        //从false变成true是一次原子操作，只会执行一次
        if(isHappen.compareAndSet(false, true)) {
            log.info("execute .. {}", isHappen);
        }
    }
}
