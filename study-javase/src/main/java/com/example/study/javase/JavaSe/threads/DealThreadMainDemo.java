package com.example.study.javase.JavaSe.threads;
/**
 * ����������̣߳��Է�����ȴ���ȡ�Է�������˫��һֱ���ڵȴ���ȡ�Է�������״̬��Ҳ����������
 * @author Jole
 *
 */
public class DealThreadMainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetalThread death = new DetalThread();
		Thread t0 = new Thread(death);
		Thread t1 = new Thread(death);
		t0.start();
		t1.start();
	}

}
