package com.example.study.vip.safeThread;
//实例方法加锁synchronized，也是用的this锁
public class SafeMethod04 implements Runnable{

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
            call();
        }
    }

    //实例方法，锁，也是this锁
    public synchronized void call(){
        count --;
        System.out.println(Thread.currentThread().getName()+", count="+count);
        System.out.println("我是子线程,子线程名2:"+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("我是主线程,线程名1:"+Thread.currentThread().getName());
        SafeMethod04 safeThread01 = new SafeMethod04();
        //注意，这里是同一个对象

        new Thread(safeThread01).start();
        new Thread(safeThread01).start();
        System.out.println("我是主线程,线程名2:"+Thread.currentThread().getName());
    }
}
