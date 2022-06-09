package com.example.study.concurrency.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @description: Synchronized修饰静态方法、类
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 22:44
 * @version: 1.0
 */
@Slf4j
public class DemoSynchronizedThredd {

    //修饰类
    public static void test1(int j) {
        synchronized (DemoSynchronizedThredd.class) {
            for (int i = 0; i < 10 ;i ++){
                log.info("test1 ...i={},j={}",i,j);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10 ;i ++){
            log.info("test2 ...i={},j={}",i,j);
        }
    }

    public static void main(String[] args) {
        DemoSynchronizedThredd demoSynchronizedTwo = new DemoSynchronizedThredd();
        DemoSynchronizedThredd demoSynchronizedTwo2 = new DemoSynchronizedThredd();
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //-----------------------------------测试同一对象的方法test1,作用代码块-------------------------------------------
        executorService.execute(()->{
            demoSynchronizedTwo.test1(1);
            demoSynchronizedTwo2.test1(2);
        });
/*        输出结果:
23:49:32.176 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=0,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=1,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=2,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=3,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=4,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=5,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=6,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=7,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=8,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=9,j=1
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=0,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=1,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=2,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=3,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=4,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=5,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=6,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=7,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=8,j=2
23:49:32.181 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test1 ...i=9,j=2*/



        //-----------------------------------测试同一对象的方法test2，作用方法-------------------------------------------
/*        executorService.execute(()->{
            demoSynchronizedTwo.test2(1);
            demoSynchronizedTwo2.test2(2);
        });*/

/*        输出结果：
23:47:13.674 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=0,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=1,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=2,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=3,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=4,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=5,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=6,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=7,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=8,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=9,j=1
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=0,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=1,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=2,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=3,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=4,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=5,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=6,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=7,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=8,j=2
23:47:13.681 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedThredd - test2 ...i=9,j=2*/

        executorService.shutdown();
        /**
         * 说明：修饰类和修改静态方法是一样的
         */
    }
}
