package com.example.study.javase.JavaSe.threads;
/**
 * 二、优化原始的线程安全解决办法，同步锁方法，同步锁对象为this
 * @author Jole
 *
 */
public class Tickets02 implements Runnable{
	//总票数
	private int tickets =100;
	//原始同步锁
//	Object obj = new Object();

	public void run() {
		bay();
	}
	
	//第一次优化，将锁和代码块抽为一个方法,测试同步锁为obj
//	public void bay() {
//		while(true) {
//			synchronized (obj) {
//				if(tickets > 0) {
//					try {
//						Thread.sleep(20);
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName()+" " +tickets-- );
//				}
//			}
//		}
//	}
	
	//第二次进一步优化为，同步方法，此时同步锁为：this
	//测试就可以省去以前的obj对象的创建了，代码以前更占用少一点内存了
	public synchronized void bay() {
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
