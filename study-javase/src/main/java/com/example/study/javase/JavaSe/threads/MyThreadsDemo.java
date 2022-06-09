package com.example.study.javase.JavaSe.threads;

public class MyThreadsDemo extends Thread{
	public MyThreadsDemo() {
		super("Google");
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
