package com.example.study.javase.JavaSe.mycalss;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;


/**
 * 读取配置文件，通过反射调用不同对象的成员方法
 * @author Jole
 *
 */
public class ConfigPropertiesRun {

	public static void main(String[] args) throws Exception{
		//读取配置文件，注意配置文件路径为src下
		FileReader fr = new FileReader("iconfig.properties"); 
		Properties pr = new Properties();
		pr.load(fr);
		fr.close();
		//获取配置文件数据
		String className = pr.getProperty("className");
		String classMethod = pr.getProperty("classMethod");
		
		//反射，并获取对象
		Class c = Class.forName(className);
		Object obj  = c.newInstance();
		
		//反射获取成员方法
		Method m = c.getMethod(classMethod);
		//反射调用成员方法
		m.invoke(obj);
	}

}
