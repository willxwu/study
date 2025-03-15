package com.example.study.vip.thread;

/**
 * 匿名内部类实现
 */
public class CreateNoName03 {
    public static void main(String[] args) {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
            }
        }).start();

    }
}
