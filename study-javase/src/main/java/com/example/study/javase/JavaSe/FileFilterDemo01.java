package com.example.study.javase.JavaSe;

import java.io.File;
/**
 * FileFilter文件过滤器
 * @author Jole
 *
 */
public class FileFilterDemo01 {

	public static void main(String[] args) {
		File f = new File("H:\\");
		File [] filsArray =f.listFiles(new MyFilter());
		for(File file : filsArray) {
			System.out.println("路径: "+file+"大小: "+file.length());
		}
	}
}
