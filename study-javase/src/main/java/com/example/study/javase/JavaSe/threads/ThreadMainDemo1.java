package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用线程池实现异步提交求和：1+...100=   1+... 200=
 * 注意：
 *    有返回值
 *    计算不同的值
 * @author Jole
 *
 */
public class ThreadMainDemo1 {

	public static void main(String[] args) throws Exception{
		//使用线程池工场Executors创建线程池
		ExecutorService es = Executors.newFixedThreadPool(3);
		//使用线程池中的线程，并使用构造方法传参，求和并返回
		Future<Integer> f =es.submit(new CallableDemo(100));
		
		Future<Integer> f2 =es.submit(new CallableDemo(2100));
		
		System.out.println("1+...100="+f.get());
		System.out.println("1+...200="+f2.get());
		
		//关闭线程池
		es.shutdown();
	}

}
