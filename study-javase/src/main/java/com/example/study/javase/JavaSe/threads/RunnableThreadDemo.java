package com.example.study.javase.JavaSe.threads;

public class RunnableThreadDemo implements Runnable{

	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("run..."+i);
		}
	}
}
