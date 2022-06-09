package com.example.study.concurrency.concurrency.atomic;

import com.example.study.concurrency.concurrency.annotation.UnThreadSafety;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 线程不安全，不正确的
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/19 19:28
 * @version: 1.0
 */
@UnThreadSafety
@Slf4j
public class DemoSemaphoreAndCountDownLatch {

    //用户数量
    private static final int clientsTotal = 5000;
    //并发数量
    private static final int concurrencyTotal = 200;
    //累加总和
    private static int count = 0;

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
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("出现错误:【{}】", e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("累加结果为count=【{}】",count);
    }

    /**
     * 累加
     */
    private  static void add(){
        count++;
    }

}
