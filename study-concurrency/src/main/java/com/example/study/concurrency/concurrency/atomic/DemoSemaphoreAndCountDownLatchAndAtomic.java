package com.example.study.concurrency.concurrency.atomic;

import com.example.study.concurrency.concurrency.annotation.ThreadSafety;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 线程安全
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/19 20:05
 * @version: 1.0
 */
@Slf4j
@ThreadSafety
public class DemoSemaphoreAndCountDownLatchAndAtomic {

    //用户数量
    private static final int clientsTotal = 5000;
    //并发数量
    private static final int concurrencyTotal = 200;
    //累加总和
    private static AtomicInteger count = new AtomicInteger(0);

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
        log.info("累加结果为count=【{}】",count.get());
    }

    /**
     * 累加
     */
    private  static void add(){
        //说明:incrementAndGet、getAndIncrement类似,i++与++i
        count.incrementAndGet();
        count.getAndIncrement();
    }
}
