package com.example.study.javase.JavaSe.threads;
/**
 * 继承Thread创建线程，设置线程名称、获取线程名称
 * @author Jole
 *
 */
public class ThreadDemo01 {

	public static void main(String[] args) {
		MyThreadsDemo mt = new MyThreadsDemo();
		mt.setName("Hi");
		mt.start();
		//获取当前线程
		Thread t = Thread.currentThread();
		System.out.println(t.getName());

	}

}
