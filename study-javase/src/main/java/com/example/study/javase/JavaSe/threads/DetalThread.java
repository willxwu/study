package com.example.study.javase.JavaSe.threads;

public class DetalThread implements Runnable{

	private int number = 0;
	public void run() {
		while(true) {
			if(number % 2 ==0) {
				synchronized (LockA.lockA) {
					System.out.println(Thread.currentThread().getName()+"线程，"+"第"+number+"次，"+"if抢到资源--获取到--同步锁A对象");
					synchronized (LockB.lockB) {
						System.out.println(Thread.currentThread().getName()+"线程，"+"第"+number+"次，"+"if抢到资源--获取到--同步锁B对象");
					}
				}
			}else {
				synchronized (LockB.lockB) {
					System.out.println(Thread.currentThread().getName()+"线程，"+"第"+number+"次，"+"else抢到资源--获取到--同步锁B对象");
					synchronized (LockA.lockA) {
						System.out.println(Thread.currentThread().getName()+"线程，"+"第"+number+"次，"+"else抢到资源--获取到--同步锁A对象");
					}
				}
			}
			number++;
		}
	}
}
