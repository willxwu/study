package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 通过线程池，实现Callable接口，实现多线程，并获取任务(run)返回值，和异常
 * @author Jole
 *
 */
public class ThreadPoolDemo2 {

	public static void main(String[] args) throws Exception{
		//使用线程池工场Executors创建线程池工场
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//通过实现Callable实现线程,提交并返回Future对象
		Future t = es.submit(new ThreadCallableDemo());
		//通过get获取返回值
		System.out.println(t.get());
	}

}
