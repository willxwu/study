package com.example.study.javase.JavaSe.threads;

public class ThreadPoolThreas implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName()+"线程池的使用");
	}
}
