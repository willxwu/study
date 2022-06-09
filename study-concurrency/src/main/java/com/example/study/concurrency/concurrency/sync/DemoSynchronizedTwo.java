package com.example.study.concurrency.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @description: Synchronized修饰代码块、修改方法，作用对象为调用对象
 * 这里测试，不同对象，启动不同进程，调同一方法
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 22:44
 * @version: 1.0
 */
@Slf4j
public class DemoSynchronizedTwo {

    /**
     * 修饰代码块，大括号被称为 同步代码块，
     * 作用范围：代码块内
     * 作用对象：调用代码块的对象
     */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10 ;i ++){
                log.info("test1 ...i={},j={}",i,j);
            }
        }
    }

    /**
     * 修饰方法，该方法被称为同步方
     * 作为范围：整个test2方法
     * 作用对象：调用代码块的对象
     */
    public synchronized void test2(int j) {
        for (int i = 0; i < 10 ;i ++){
            log.info("test2 ...i={},j={}",i,j);
        }
    }

    public static void main(String[] args) {
        DemoSynchronizedTwo demoSynchronizedTwo = new DemoSynchronizedTwo();
        DemoSynchronizedTwo demoSynchronizedTwo2 = new DemoSynchronizedTwo();
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //-----------------------------------测试同一对象的方法test1,作用代码块-------------------------------------------
//        executorService.execute(()->{
//            demoSynchronizedTwo.test1(1);
//            demoSynchronizedTwo2.test1(2);
//        });
/*        输出结果:
        23:28:57.763 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=0,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=1,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=2,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=3,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=4,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=5,j=1
        23:28:57.768 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=6,j=1
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=7,j=1
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=8,j=1
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=9,j=1
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=0,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=1,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=2,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=3,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=4,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=5,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=6,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=7,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=8,j=2
        23:28:57.769 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test1 ...i=9,j=2*/

        /*
        * 结论：说明作用于同步代码，不同对象的调用是相互不影响的
        * */


        //-----------------------------------测试同一对象的方法test2，作用方法-------------------------------------------
        executorService.execute(()->{
            demoSynchronizedTwo.test2(1);
            demoSynchronizedTwo2.test2(2);
        });

/*        输出结果：
        23:34:56.130 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=0,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=1,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=2,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=3,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=4,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=5,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=6,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=7,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=8,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=9,j=1
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=0,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=1,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=2,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=3,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=4,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=5,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=6,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=7,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=8,j=2
        23:34:56.135 [pool-1-thread-1] INFO com.yanxizhu.demo.concurrency.sync.DemoSynchronizedTwo - test2 ...i=9,j=2*/

        /*
         * 结论：说明作用于方法，不同对象的调用是相互不影响的
         * */
        executorService.shutdown();
    }
}
