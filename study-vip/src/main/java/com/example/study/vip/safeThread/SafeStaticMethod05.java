package com.example.study.vip.safeThread;
//加在静态方法上，则使用类名.class
public class SafeStaticMethod05 implements Runnable{

    public static int count =50;

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

    //静态方法，锁类.class
    public static void call(){
        synchronized(SafeStaticMethod05.class){
            count --;
            System.out.println(Thread.currentThread().getName()+", count="+count);
            System.out.println("我是子线程,子线程名2:"+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        System.out.println("我是主线程,线程名1:"+Thread.currentThread().getName());
        SafeStaticMethod05 safeThread01 = new SafeStaticMethod05();
        //注意，这里是同一个对象

        new Thread(safeThread01).start();
        new Thread(safeThread01).start();
        System.out.println("我是主线程,线程名2:"+Thread.currentThread().getName());
    }
}
