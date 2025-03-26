package com.example.study.vip.safeThread;

public class DeathLock implements Runnable{
    int count = 1;
    private String lock="lock";
    @Override
    public void run() {
        while (true){
            count++;
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            if(count%2==0){
                synchronized (lock){
                    a();
                }
            }else{
                synchronized (this){
                    b();
                }
            }
        }
    }

    public synchronized  void a(){
        System.out.println(Thread.currentThread().getName()+".....a");
    }

    public void b(){
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"......b");
        }
    }

    public static void main(String[] args) {
        DeathLock deathLock = new DeathLock();
        new Thread(deathLock).start();
        new Thread(deathLock).start();
    }
}
