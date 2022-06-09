package com.example.study.javase.JavaSe.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

import java.sql.Connection;
/**
 * jdbc使用
 * @author Jole
 *
 */
public class MyDriver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获取数据库连接对象
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "9yMTeYWq7tbaoFsw";
		Connection conn = DriverManager.getConnection(url, user, password);
//		System.out.println(conn);
		
		//3.获取连接平台的执行对象
//		Statement st = conn.createStatement();
		
		
		//4.执行sql,返回行数
		//executeUpdate():增删改
        //String sql = "insert into user(user_id,user_name,user_password) values('1320442338427273213','zss','12')";
        //int n = st.executeUpdate(sql);
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int age = scan.nextInt();
		
		//为了防止sql注入攻击和提高效率，使用Statement的子类，进行预编译
		//executeQuery（）:查询
		String sql = "select * from my_user where u_name=? and u_age=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, name);
		ps.setObject(2, age);
		
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();

		//5.处理结果
		while(rs.next()) {
			System.out.println(rs.getString("u_name")+ " " + rs.getString("u_age"));
		}
		
		//6.释放资源
		rs.close();
		ps.close();
		conn.close();
	}
}
