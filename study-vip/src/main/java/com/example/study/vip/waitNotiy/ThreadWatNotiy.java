package com.example.study.vip.waitNotiy;

/**
 * wait、notify必须和锁对象一起使用，notify必须放在synchronized代码里面使用，并且是在线程方法外，才有效
 */
public class ThreadWatNotiy {
    private Object objLock = new Object();

    public static void main(String[] args) {
        new ThreadWatNotiy().print();
    }

    public void print(){

        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (objLock){
                    System.out.println(Thread.currentThread().getName()+"======="+"1");
                    try {
                        objLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"======="+"2");
                }
            }
        }).start();

        //3秒后唤醒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (objLock){
            objLock.notify();
        }
    }

}
