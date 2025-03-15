package com.example.study.vip.thread;

/**
 * 实现Runnable接口
 */
public class CreateImpleRunanle02 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        new Thread(new CreateImpleRunanle02()).start();
        new Thread(new CreateImpleRunanle02()).start();
    }
}
