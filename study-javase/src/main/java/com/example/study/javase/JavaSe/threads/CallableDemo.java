package com.example.study.javase.JavaSe.threads;

import java.util.concurrent.Callable;
/**
 * ͨ��ʵ��Callable�ӿڣ������췽�����Σ���ͨ��call����ֵ
 * @author Jole
 *
 */
public class CallableDemo implements Callable<Integer>{
	
	private int number;
	
	//�������췽����Ϊ�˴���
	public CallableDemo(int number) {
		this.number = number;
	}
	
	public Integer call() {
		int sum = 0;
		//ʹ�ù��췽�����Ĳ�����Ͳ�����
		for(int i=0;i<=number;i++) {
			sum=sum+i;
		}
		return sum;
	}
}
