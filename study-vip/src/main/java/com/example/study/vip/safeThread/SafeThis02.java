package com.example.study.vip.safeThread;

// synchronized this锁，this的含义是，使用同一个对象创建多线程，这个this就是指当前这一个对象。
// 如果多个实例对象，分别创建线程则，相当于锁的2个对象的this，锁的都是自己，当然没用
public class SafeThis02 implements Runnable{

    public int count =50;
    @Override
    public void run() {
        System.out.println("我是子线程,子线程名1:"+Thread.currentThread().getName());
        while(count>1){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //锁，同一个实例，this对象
            synchronized (this){
                count --;
                System.out.println(Thread.currentThread().getName()+", count="+count);
                System.out.println("我是子线程,子线程名2:"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("我是主线程,线程名1:"+Thread.currentThread().getName());
        SafeThis02 safeThread01 = new SafeThis02();
        //注意，这里是同一个对象

        new Thread(safeThread01).start();
        new Thread(safeThread01).start();
        System.out.println("我是主线程,线程名2:"+Thread.currentThread().getName());
    }
}
