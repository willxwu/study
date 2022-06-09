package com.example.study.javase.JavaSe.jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
/**
 * 利用开源apache的commons-dbutils-1.7.jar的QueryRunner封装数据
 * @author Jole
 *
 */
public class QueryRunnerDemo01 {

	public static final Connection conn = JdbcUtils.getConnection();
	public static final QueryRunner qr = new QueryRunner();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		getInfo();
//		getInfo2();
//		getInfo3();
//		getInfo4();
//		getInfo5();
//		getInfo6();
//		getInfo7();
		getInfo8();
	}
	
	//ArrayHandler 第一行
	public static void getInfo() throws Exception{
		String sql ="select * from my_user";
		Object[] rs = qr.query(conn, sql, new ArrayHandler());
		for(Object obj : rs) {
			System.out.print(obj + "\t");	
		}
		
	}
	
	//ArrayListHandler 所有记录
	public static void getInfo2() throws Exception{
		String sql ="select * from my_user";
		List<Object[]> rs = qr.query(conn, sql, new ArrayListHandler());
		for(Object[] objs : rs) {
			for(Object obj : objs) {
				System.out.print(obj + "\t");	
			}	
			System.out.println();
		}
	}
	
	//javaBean 第一行封装成对象
	public static void getInfo3() throws Exception{
		String sql ="select * from my_user";
		User user = qr.query(conn, sql, new BeanHandler<User>(User.class));
		System.out.println(user);
	}
	
	//javaBean 所有记录封装成对象
	public static void getInfo4() throws Exception{
		String sql ="select * from my_user";
		List<User> userList = qr.query(conn, sql, new BeanListHandler<User>(User.class));
		for(User user : userList) {
			System.out.println(user);	
		}
	}
	
	//ColumnListHandler所有记录的某列值
	public static void getInfo5() throws Exception{
		String sql ="select * from my_user";
		List<Object> list = (List<Object>) qr.query(conn, sql, new ColumnListHandler("u_name"));
		for(Object obj : list) {
			System.out.println(obj);	
		}
	}
	
	//ScalarHandler返回单个值
	public static void getInfo6() throws Exception{
		String sql ="select count(*) from my_user";
		Long count =  qr.query(conn, sql, new ScalarHandler<Long>());
		System.out.println(count);
	}
	
	//MapHandler将第一行数据封到map中
	public static void getInfo7() throws Exception{
		String sql ="select * from my_user";
		Map<String, Object> map =  qr.query(conn, sql, new MapHandler());
		
		Set<String> set =map.keySet();
		for(String key : set) {
			System.out.println(key+" "+map.get(key));
		}
	}
	
	//MapListHandler将所有数据封到list中的map中
	public static void getInfo8() throws Exception{
		String sql ="select * from my_user";
		List<Map<String, Object>> list=  qr.query(conn, sql, new MapListHandler());
		for(Map<String, Object> map : list) {
			for(String key : map.keySet()) {
				System.out.print(key+" "+ map.get(key));
			}
			System.out.println();
		}
	}

}
