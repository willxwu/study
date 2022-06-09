package com.example.study.javase.JavaSe.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcDemo {

	public static void main(String[] args) throws Exception{
		InputStream in = JdbcDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		System.out.println("111"+in);
		Properties pro = new Properties();
		pro.load(in);
		in.close();
		String driverClass = pro.getProperty("driverClass");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String url = pro.getProperty("url");
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "select * from my_user";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("u_name")+ " " + rs.getString("u_age"));
		}
		rs.close();
		ps.close();
		conn.close();
	}

}
