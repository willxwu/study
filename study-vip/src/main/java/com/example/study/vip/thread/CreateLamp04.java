package com.example.study.vip.thread;

/**
 * 使用jdk8的lamp
 */
public class CreateLamp04 {

    public static void main(String[] args) {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());

        new Thread(()-> System.out.println("我是子线程,子线程名:"+Thread.currentThread().getName())).start();
    }
}
