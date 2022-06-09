package com.example.study.javase.JavaSe.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
/**
 * 利用apatche的DBUtils工具包，添加\修改\删除数据
 * @author Jole
 *
 */
public class DbUtilsDemo {

	private static Connection conn = JdbcUtils.getConnection();
	private static QueryRunner qr = new QueryRunner();
	
	public static void main(String[] args) throws Exception{
//		insert();
//		update();
		delte();
	}
	
	public static void insert() throws SQLException{
		String sql = "insert into my_user(u_id,u_name,u_age) values(11111,'inster',10)";
		Object[] param = {};
		int n = qr.update(conn, sql, param);
		System.out.println(n);
		DbUtils.close(conn);
	}
	
	public static void update() throws SQLException{
		String sql ="update my_user set u_name=? ,u_age=? where u_id=?";
		Object[] param = {"ceshi",1000,11111};
		int n = qr.update(conn, sql, param);
		DbUtils.close(conn);
		System.out.println(n);
	}
	
	public static void delte() throws SQLException{
		String sql = "delete from my_user where u_id=?";
		int n = qr.update(conn, sql, 11111);
		DbUtils.close(conn);
		System.out.println(n);
	}

}
