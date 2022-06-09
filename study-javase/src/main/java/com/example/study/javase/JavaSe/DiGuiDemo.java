package com.example.study.javase.JavaSe;
/**
 * 递归的使用
 * @author Jole
 *
 */
public class DiGuiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int all = getSum(100);
		int c=getC(3);
		int t=getT(3);
		System.out.println(all);
		System.out.println(c);
		System.out.println(t);
	}
	
	public static int getSum(int n) {
		if(n==1) {
			return 1;
		}else {
			return n+getSum(n-1);
		}
	}
	
	public static int getC(int n) {
		if(n==1) {
			return 1;
		}else {
			return n*getC(n-1);
		}
	}
	
	public static int getT(int t) {
		if(t==1) {
			return 1;
		}
		if(t==2) {
			return 1;
		}
		return getT(t-1)+getT(t-2);
	}

}
