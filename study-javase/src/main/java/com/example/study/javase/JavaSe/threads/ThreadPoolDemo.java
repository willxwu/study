package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author Jole
 *
 */
public class ThreadPoolDemo {

	public static void main(String[] args) {
		//使用线程池工场Executors，创建线程池
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//使用线程池,构造器为实现Runnable的接口，使用完后自动放回线程池
		es.submit(new ThreadPoolThreas());
		es.submit(new ThreadPoolThreas());
		
		//如果线程池里面线程不够了，只有等待其它线程执行完后，在使用
		es.submit(new ThreadPoolThreas());
		
		//一般不用关闭线程池，特殊情况关闭线程池，可以使用
//		es.shutdown();
	}

}
