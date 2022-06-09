package com.example.study.javase.JavaSe;
/**
 * 抛出异常  new 异常名称，继承RuntimeException运行时异常
 * @author Jole
 *
 */
public class TryDemoException extends RuntimeException{

	public TryDemoException(String s) {
		super(s);
	}
}
