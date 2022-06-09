package com.example.study.javase.JavaSe;

import java.io.File;
/**
 * File常用操作
 * @author Jole
 *
 */
public class FileDemo01 {

	public static void main(String[] args) {
		File file = new File("H://");
		//此抽象路径名表示的文件或目录的名称；如果路径名的名称序列为空，则返回空字符串
		System.out.println(file.getName());
		//返回文件大小
		System.out.println(file.length());
		//返回绝对路径
		System.out.println(file.getAbsolutePath());
		//绝对路径名
		System.out.println(file.getAbsoluteFile());
		//父目录
		System.out.println(file.getParentFile());
		//是否存在
		System.out.println(file.exists());
		//是否是目录
		System.out.println(file.isDirectory());
		//返回路径下的文件或文件夹
		System.out.println(file.list());
		
		for(String path : file.list()) {
			//获取路径
			System.out.println(path);
		}
		//可用的文件系统根
		System.out.println("listRoots:"+file.listRoots());
		
		for(File f : file.listFiles()) {
			System.out.println("111"+f);
			System.out.println(f.list());
			System.out.println(f.length());
			System.out.println("111"+f.listRoots());
		}
	}
}
