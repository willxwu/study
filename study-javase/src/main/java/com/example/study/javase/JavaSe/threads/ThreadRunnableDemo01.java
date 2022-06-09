package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手动获取锁，释放锁
 * @author Jole
 *
 */
public class ThreadRunnableDemo01 implements Runnable{

	//票总数
	private int tickets = 100;
	
	//锁 Lock接口的实现类ReentrantLock
	private Lock lock = new ReentrantLock();
	
	public void run() {
		while(true) {
			//获取锁
			lock.lock();
			try {
				if(tickets > 0) {
					Thread.sleep(20);
					System.out.println(Thread.currentThread().getName()+" "+tickets--);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//释放锁
				lock.unlock();
			}
		}
	}
}
