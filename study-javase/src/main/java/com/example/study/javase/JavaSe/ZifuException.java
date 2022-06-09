package com.example.study.javase.JavaSe;
/**
 * 子夫类异常
 * 1. 子类覆盖父类方法时，如果父类的方法声明异常，子类只能声明父类异常或者该异常的子类，或者不声明。
 * 2. 当父类方法声明多个异常时，子类覆盖时只能声明多个异常的子集。
 * 3. 当被覆盖的方法没有异常声明时，子类覆盖时无法声明异常的。
 * @author Jole
 *
 */
public class ZifuException extends FuException{
	
	//抛出父类一样的异常
	public void method() throws RuntimeException {
		
	}  
	//抛出父类子异常
    public void method2() throws NullPointerException{
    	
    }
}
