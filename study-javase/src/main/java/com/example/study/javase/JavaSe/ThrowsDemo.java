package com.example.study.javase.JavaSe;
/**
 * 异常的抛出（throw）与声明（throws）
 * @author Jole
 *
 */
public class ThrowsDemo {
	public static void main(String[] args){
		String[] str = {};
//		System.out.println(throwT(null));
		System.out.println(throwT2(null));
	}
	
	public static int throwT(String[] arr) throws NullPointerException{
		if(arr==null) {
			throw new NullPointerException("数组不能为空！");
		}
		int num = arr.length;
		return num;
	}
	
	public static int throwT2(String[] arr){
		int num =0;
		try {
			num = arr.length;
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			System.out.println("hhhhh");
		}
		return num;
	}
}
