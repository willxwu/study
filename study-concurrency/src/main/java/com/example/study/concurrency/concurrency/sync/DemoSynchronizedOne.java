package com.example.study.concurrency.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: Synchronized修饰代码块、修改方法，作用对象为调用对象
 * 这里测试，同一对象，启动不同进程，调同一方法
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 22:44
 * @version: 1.0
 */
@Slf4j
public class DemoSynchronizedOne {

    /**
     * 修饰代码块，大括号被称为 同步代码块，
     * 作用范围：代码块内
     * 作用对象：调用代码块的对象
     */
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10 ;i ++){
                log.info("test1 ...i={}",i);
            }
        }
    }

    /**
     * 修饰方法，该方法被称为同步方
     * 作为范围：整个test2方法
     * 作用对象：调用代码块的对象
     */
    public synchronized void test2() {
        for (int i = 0; i < 10 ;i ++){
            log.info("test2 ...i={}",i);
        }
    }

    public static void main(String[] args) {
        DemoSynchronizedOne demoSynchronized = new DemoSynchronizedOne();
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 说明: 为什么执行2次
         * 如果不用线程池，下面2次调用都是同一线程，不能验证。
         * 使用线程池，相当于用了2各进程去执行test1，不用等一个进程执行完，在执行第二个线程，
         * 这样才能看到同一个对象的不同进程的执行情况。
         */
        //-----------------------------------测试同一对象的方法test1-------------------------------------------
//        测试1：
       executorService.execute(() -> {
           demoSynchronized.test1();
        });
        executorService.execute(() -> {
            demoSynchronized.test1();
        });

/*        输出结果：
23:33:52.670 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=0
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=1
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=2
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=3
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=4
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=5
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=6
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=7
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=8
23:33:52.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=9
23:33:52.674 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=0
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=1
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=2
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=3
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=4
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=5
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=6
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=7
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=8
23:33:52.675 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test1 ...i=9*/

        //-----------------------------------测试同一对象的方法test2-------------------------------------------
//        测试2：
        executorService.execute(() -> {
            demoSynchronized.test2();
        });
        executorService.execute(() -> {
            demoSynchronized.test2();
        });

/*        输出结果：
23:33:24.291 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=0
23:33:24.295 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=1
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=2
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=3
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=4
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=5
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=6
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=7
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=8
23:33:24.296 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=9
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=0
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=1
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=2
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=3
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=4
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=5
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=6
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=7
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=8
23:33:24.296 [pool-1-thread-2] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedOne - test2 ...i=9*/

        executorService.shutdown();
    }
}
