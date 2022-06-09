package com.example.study.javase.JavaSe.jdbc;

public class User {

	private String u_id;
	private String u_name;
	private String u_age;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_age() {
		return u_age;
	}
	public void setU_age(String u_age) {
		this.u_age = u_age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String u_id, String u_name, String u_age) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_age = u_age;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_age=" + u_age + "]";
	}
	
	
}
