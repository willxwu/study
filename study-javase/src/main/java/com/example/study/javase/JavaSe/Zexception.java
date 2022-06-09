package com.example.study.javase.JavaSe;
/**
 * 子类异常
 * @author Jole
 *
 */
public class Zexception extends Fexception{
	//抛出父类全部异常
	public void method() throws NullPointerException, ClassCastException {
		
	}        
	//抛出父类异常中的一部分
//    public void method() throws NullPointerException{
    	
//    } 
    //抛出父类异常中的一部分
//    public void method() throws ClassCastException {
    	
//    } 
}
