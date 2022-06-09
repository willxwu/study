package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.Callable;
/**
 * 通过实现Callable接口，及构造方法传参，并通过call返回值
 * @author Jole
 *
 */
public class CallableDemo implements Callable<Integer>{
	
	private int number;
	
	//创建构造方法，为了传参
	public CallableDemo(int number) {
		this.number = number;
	}
	
	public Integer call() {
		int sum = 0;
		//使用构造方法传的参数求和并返回
		for(int i=0;i<=number;i++) {
			sum=sum+i;
		}
		return sum;
	}
}
