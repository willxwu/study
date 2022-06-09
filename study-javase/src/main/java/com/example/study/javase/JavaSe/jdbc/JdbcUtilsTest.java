package com.example.study.javase.JavaSe.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtilsTest {

	public static void main(String[] args) throws Exception{
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from my_user");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("u_name")+ " " + rs.getString("u_age"));
		}
	}

}
