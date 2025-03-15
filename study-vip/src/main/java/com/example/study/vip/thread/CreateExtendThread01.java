package com.example.study.vip.thread;

/**
 * 继承Thread类
 *
 */
public class CreateExtendThread01 extends Thread{
    @Override
    public void run(){
        System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
//        开始启动线程不是马上就会执行
        new CreateExtendThread01().start();
        new CreateExtendThread01().start();
    }
}
