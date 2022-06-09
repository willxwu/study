package com.example.study.javase.JavaSe.threads;
/**
 * 死锁：多个线程，对方互相等待获取对方的锁。双方一直处于等待获取对方锁对象状态，也就是死锁。
 * @author Jole
 *
 */
public class DealThreadMainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetalThread death = new DetalThread();
		Thread t0 = new Thread(death);
		Thread t1 = new Thread(death);
		t0.start();
		t1.start();
	}

}
