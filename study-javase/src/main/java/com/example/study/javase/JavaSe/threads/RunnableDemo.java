package com.example.study.javase.JavaSe.threads;
/**
 * 实现Runnable接口，创建线程。
 * 继承Thread接口与实现Runnable接口，实现多线程区别：
 * 1、单继承、多实现
 * 2、将线程与任务(run（）)解耦
 * @author Jole
 *
 */
public class RunnableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new RunnableThreadDemo()).start();
		for(int i=0;i<5;i++) {
			System.out.println("main..."+i);
		}
	}

}
