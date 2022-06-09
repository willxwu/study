package com.example.study.javase.JavaSe.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils{
	private static Connection conn;
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			getReadConfig();
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			new RuntimeException("链接数据库失败！");
		}
	}
	
	private static void getReadConfig() throws Exception{
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pro = new Properties();
		pro.load(in);
		driverClass =pro.getProperty("driverClass");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
	}
	
	public static Connection getConnection() {
		return conn;
	}

}
