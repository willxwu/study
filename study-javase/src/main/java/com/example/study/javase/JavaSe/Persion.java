package com.example.study.javase.JavaSe;

import java.io.Serializable;
/**
 * 实现Serializable接口的目的是为了可以被序列化，
 * transient关键字标记的标量不会被序列化
 * @author Jole
 *
 */
public class Persion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2056540569585913293L;
	private String name;
	private transient int age;
	
	public Persion(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Persion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + "]";
	}
	
}
