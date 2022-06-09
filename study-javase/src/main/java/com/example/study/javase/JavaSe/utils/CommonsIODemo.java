package com.example.study.javase.JavaSe.utils;

import org.apache.commons.io.FilenameUtils;
/**
 * Commons-io工具类 FilenameUtis常用方法
 * @author Jole
 *
 */
public class CommonsIODemo {

	public static void main(String[] args) {
		//打印后缀，没有则为空
		String name = FilenameUtils.getExtension("demo.java");
		System.out.println(name);
		
		//获取文件名
		String fileName = FilenameUtils.getName("H:\\z.txt");
		System.out.println(fileName);
		
		//判断后缀名
		boolean Extension = FilenameUtils.isExtension("World.java", "java");
		System.out.println(Extension);
		
	}

}
