package com.example.study.javase.JavaSe.mycalss;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 一、获取class的三种方式
 * 
 * 二、获取公有构造方法
 * 注意：
 * 1、被反射的类必须是有空参数的构造器
 * 2、构造方法必须是public的才能反射获取
 * 
 * 三、获取所有构造方法
 * 
 * @author Jole
 *
 */
public class ClassDemo {

	public static void main(String[] args) throws Exception{
		// 方式1、.getClass()
		Person p = new Person();
		Class c = p.getClass();
		System.out.println(c);
		//方式2、类名.class
		Class c3 = Person.class;
		System.out.println(c3);
		//方式3、Class.forName(类全名);
		Class c2 = Class.forName("learn.javase.mycalss.Person");
		System.out.println(c2);
			
		Class personClass = Class.forName("learn.javase.mycalss.Person");
		//获取public所有构造方法
		Constructor[] cons = personClass.getConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
		//获取public无参构造方法
		Constructor cc = personClass.getConstructor();
		Person pp = (Person)cc.newInstance();
		//获取public有参构造方法
		Constructor  ccc = personClass.getConstructor(String.class, int.class);
		Person ppp = (Person)ccc.newInstance("张三",122);
		System.out.println(ppp);
		
		//获取所有包括private的构造方法
		Constructor[] conss = personClass.getDeclaredConstructors();
		for(Constructor co: conss ) {
			System.out.println(co);
		}
		//获取私有构造方法
		Constructor ct = personClass.getDeclaredConstructor(String.class);
		ct.setAccessible(true);
		Person ps = (Person)ct.newInstance("zhangsan");
		System.out.println(ps.toString());
		
		//获取所有公共成员变量
		Field[] fis = personClass.getFields();
		for(Field fi : fis) {
			System.out.println("成员变量："+fi);
		}
		
		//获取私有成员变量
		Field fd = personClass.getDeclaredField("name");
		System.out.println(fd);
		//修改成员变量的值
		Object obj = personClass.newInstance();
		fd.set(obj, "哈哈");
		fd.setAccessible(true);
		System.out.println(obj);
		
		//获取所有公共成员方法
		Method[] md = personClass.getMethods();
		for(Method m : md) {
			System.out.println("所有公共成员方法："+m);
		}
		
		
		//获取单个无参成员方方法
		Method mt = personClass.getMethod("say");
		mt.invoke(personClass.newInstance());
		
		//获取单个有参成员方法，并运行
		Method me = personClass.getMethod("say", String.class);
		Object objd = personClass.newInstance();
		Object ob = me.invoke(objd, "Hello World");
		System.out.println(ob);
		
		
		//反射泛型的擦除
		List<String> list = new ArrayList<String>();
		//正常情况只能存String类型，但是通过反射可以存其他类型
		Class li = list.getClass();
		Method mmm = li.getMethod("add", Object.class);
		mmm.invoke(list, 1000);
		mmm.invoke(list, 444);
		mmm.invoke(list,999L);
		mmm.invoke(list, 'c');
		System.out.println(list);
		
	}

}
