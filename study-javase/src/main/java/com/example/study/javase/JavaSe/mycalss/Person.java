package com.example.study.javase.JavaSe.mycalss;

public class Person {
	public String name;
	private int age;

	public static final int n=10;
	public Person() {};
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	};
	
	private Person(String name) {
		this.name=name;
	}
	
	public void say() {
		System.out.println("无参成员方法");
	}
	
	public String say(String info) {
		System.out.println("Person----say:"+info);
		return info;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public String toStrings() {
		return "Person [name=" + name;
	}
}
