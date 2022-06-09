package com.example.study.javase.JavaSe.threads;
/**
 * 静态同步方法，此时同步锁为：类名.class
 * 如此类中的同步锁对象是：Tickets03.class
 * @author Jole
 *
 */
public class Tickets03 implements Runnable{

	//总票数
	private static int tickets =100;
	public void run() {
		buy();
	}
	
	//静态方法同步锁，此时代码的锁为：Tickets03.class
	public static synchronized void buy() {
		while(true) {
			if(tickets > 0) {
				try {
					Thread.sleep(20);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" " + tickets--);
			}
		}
	}
}
