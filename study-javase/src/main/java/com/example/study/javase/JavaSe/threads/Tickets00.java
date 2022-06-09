package com.example.study.javase.JavaSe.threads;
/** 〇、原始多线程，会出现安全问题，会出现票卖完了还在卖，也就是会出现票为负数的情况
 * @author Jole
 *
 */
public class Tickets00 implements Runnable{
	//票的数量
	private int ticket = 100;
	public void run() {
		while(true) {
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