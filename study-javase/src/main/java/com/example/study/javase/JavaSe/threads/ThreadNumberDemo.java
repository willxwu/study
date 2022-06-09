package com.example.study.javase.JavaSe.threads;
/**
 * 实现多线程的4中方式：
 * 1、继承Thread类
 * 2、实现Runnable接口
 * 3、匿名内部类
 * 4、匿名接口
 * 5、实现Callable接口，与Runnable的区别：
 *   可以有返回值
 *   可以抛异常
 * @author Jole
 *
 */
public class ThreadNumberDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//方式1，继承Thread
		new ThreadThread1().start();
		
		//方式2，实现Runnable接口
		new Thread(new ThreadRunnables2()).start();
		
		//方式3，匿名内部类
		new Thread() {
			public void run() {
				System.out.println("匿名内部类，实现多线程");
			}
		}.start();
		
		//方式4，匿名接口
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("匿名接口，实现多线程");
			}
		};
		new Thread(r).start();
		
		//方式4的简洁版
		new Thread(new Runnable() {
			public void run() {
				System.out.println("匿名接口简洁版，实现多线程");
			}
		}).start();
	}

}
