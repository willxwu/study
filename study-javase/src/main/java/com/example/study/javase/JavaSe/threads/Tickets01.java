package com.example.study.javase.JavaSe.threads;
/** 一、原始线程同步解决，同步锁为obj
 * 
 * synchronized解决线程安全问题，使用公式：
 * synchronized(锁(任意对象)){
 *       代码块
 * }
 * @author Jole
 *
 */
public class Tickets01 implements Runnable{
	//票的数量
	private int ticket = 100;
	Object obj = new Object();
	public void run() {
		while(true) {
			//为了解决安全问题加入了synchronized关键字
			synchronized (obj) {
				if(ticket>0) {
					//为了展示出现线程安全问题，此处让线程修改20毫秒
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//每次票减1
					System.out.println(Thread.currentThread().getName()+ " " + ticket--);
				}
			}
		}
	}
}
