package com.example.study.javase.JavaSe.threads;
/**
 * 手动获取锁，释放锁
 * @author Jole
 *
 */
public class ThreadShouDong {

	public static void main(String[] args) {
		
		ThreadRunnableDemo01 t = new ThreadRunnableDemo01();
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t0.start();
		t1.start();
		t2.start();
	}

}
