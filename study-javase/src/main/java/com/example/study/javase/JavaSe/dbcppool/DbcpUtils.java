package com.example.study.javase.JavaSe.dbcppool;

import org.apache.commons.dbcp2.BasicDataSource;
/**
 * 利用DBCP链接数据库
 * @author Jole
 *
 */
public class DbcpUtils {

	private static BasicDataSource dataSource = new BasicDataSource();
	
	static {
		//必配参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("9yMTeYWq7tbaoFsw");
		
		//可配参数
		dataSource.setInitialSize(10);
		dataSource.setMaxIdle(8);
		dataSource.setMinIdle(2);
	}
	
	public static BasicDataSource getConnecton() {
		return dataSource;
	}
}
