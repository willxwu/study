package com.example.study.javase.JavaSe.threads;
/**
 * 方式一继承Thread实现多线程
 * @author Jole
 *
 */
public class ThreadThread1 extends Thread{

	public void run() {
		System.out.println("extends ....thread");
	}
}
