package com.example.study.vip.safeThread;

/**
 * synchronized 实例方法加锁，不释放锁，其它线程不能获取锁，相当于单线程
 */
public class SafeRun01 implements Runnable {

    public int count = 50;

    @Override
    public synchronized void run() {
        System.out.println("我是子线程,子线程名1:" + Thread.currentThread().getName());
        while (count > 1) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + ", count=" + count);
            System.out.println("我是子线程,子线程名2:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("我是主线程,线程名1:" + Thread.currentThread().getName());
        SafeRun01 safeRun01 = new SafeRun01();
        //注意，这里是同一个对象
        new Thread(safeRun01).start();
        new Thread(safeRun01).start();
        System.out.println("我是主线程,线程名2:" + Thread.currentThread().getName());
    }
}
