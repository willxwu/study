package com.example.study.javase.JavaSe;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/**
 * Properties的load(),store方法
 * 读取Properties文件的值和写入值
 * @author Jole
 *
 */
public class PropertiesDemo {

	public static void main(String[] args) throws IOException{
		function();
	}
	
	public static void function() throws IOException{
		Properties pro = new Properties();
		FileInputStream fs = new FileInputStream("H:\\pro.properties");
		pro.load(fs);
		fs.close();
		FileWriter fw = new FileWriter("H:\\1.properties");
		pro.store(fw, "add");
		fw.close();
		System.out.println(pro);
	}

}
