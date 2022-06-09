package com.example.study.javase.JavaSe.threads;
/**
 * 可能出现安全问题的情况：多线程，共享一个数据
 * 线程安全问题，及解决办法加synchronized，实例：卖票
 * @author Jole
 * synchronized解决线程安全问题，使用公式：
 * synchronized(锁(任意对象)){
 *       代码块
 * }
 * 
 * 注意:因为加了锁，所以效率会降低，但是安全性得到了保证，效率低的原因如下：
 * 1、每次线程都会先判断是否有锁 
 * 2、获取锁
 * 3、执行完代码块
 * 4、执行完后，还会锁
 * 5、在等下一个锁执行相同操作，相当于只能排队上一个厕所。
 */
public class ThreadSeaerfDemo {

	public static void main(String[] args) {
		
		//多线程出现的安全问题，票有负数还在卖
//		Tickets00 t = new Tickets00();
//		Thread t0 = new Thread(t);
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		t0.start();t1.start();t2.start();

		//原始代码
//		Tickets01 t = new Tickets01();
//		Thread t0 = new Thread(t);
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		t0.start();t1.start();t2.start();
		
		//第一次优化代码:同步方法，同步锁对象为：this
//		Tickets02 t = new Tickets02();
//		Thread t0 = new Thread(t);
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		t0.start();t1.start();t2.start();
		
		
		//第一次优化代码：同步静态方法，同步锁对象为：类名.class
		Tickets03 t = new Tickets03();
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t0.start();t1.start();t2.start();
		
		
	}

}
