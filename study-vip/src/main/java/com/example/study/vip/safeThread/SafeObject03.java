package com.example.study.vip.safeThread;
//锁，任意对象
public class SafeObject03 implements Runnable{

    public int count =50;

    Object objlock = new Object();

    @Override
    public void run() {
        System.out.println("我是子线程,子线程名1:"+Thread.currentThread().getName());
        while(count>1){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            call();
        }
    }

    //任意实例一个对象，锁实这个对象
    public void call(){
        synchronized (objlock){
            count --;
            System.out.println(Thread.currentThread().getName()+", count="+count);
            System.out.println("我是子线程,子线程名2:"+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        System.out.println("我是主线程,线程名1:"+Thread.currentThread().getName());
        SafeObject03 safeThread01 = new SafeObject03();
        //注意，这里是同一个对象

        new Thread(safeThread01).start();
        new Thread(safeThread01).start();
        System.out.println("我是主线程,线程名2:"+Thread.currentThread().getName());
    }
}
