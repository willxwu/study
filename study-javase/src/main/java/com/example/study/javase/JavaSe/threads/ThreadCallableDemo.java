package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.Callable;
/**
 * 
 * @author Jole
 * 使用继承Callable<T>泛型接口，实现多线程，并使用线程池
 */
public class ThreadCallableDemo implements Callable<String>{

	public String call() {
		return "实现Callable接口";
	}
}
