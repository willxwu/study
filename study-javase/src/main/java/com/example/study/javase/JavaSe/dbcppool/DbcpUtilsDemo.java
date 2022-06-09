package com.example.study.javase.JavaSe.dbcppool;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/**
 * 利用DBCP数据库连接池增加、查询
 * @author Jole
 *
 */
public class DbcpUtilsDemo {

	private static QueryRunner qr = new QueryRunner(DbcpUtils.getConnecton());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertData();
		findData();
	}
	
	public static void insertData() {
		String sql = "insert into my_user(u_id,u_name,u_age) values(?,?,?)";
		Object[] params = {"777777","dbcpUTils",30};
		try {
			int num = qr.update(sql, params);
			System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findData() {
		String sql = "select * from my_user";
		try {
			List<List<Object[]>> objs = qr.execute(sql, new ArrayListHandler());
			for(List<Object[]> obj : objs ) {
				for(Object ob : obj) {
					System.out.println(ob);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
