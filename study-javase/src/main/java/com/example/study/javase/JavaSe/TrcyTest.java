package com.example.study.javase.JavaSe;
/**
 * 自定义异常，需集成RuntimeException运行时异常
 * @author Jole
 *
 */
public class TrcyTest {

	public static void main(String[] args) {
		getEx(1);
	}
	
	public static void getEx(int ... num){
		for(int i : num) {
			if(i==1) {
				throw new TryDemoException("不能等于1");
			}
		}
	}

}
