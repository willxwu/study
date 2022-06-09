package com.example.study.javase.JavaSe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 泛型的使用：泛型类型限制
 * @author Jole
 *
 */
public class GenericTest {

	public static void main(String[] args) {
		List<Zhangsan> zs = new ArrayList<>();
		Zhangsan zss = new Zhangsan();
		zss.setName("zhangsan");
				
		zs.add(zss);
		List<Lisi> ls = new ArrayList<>();
		List<Wangwu> ww = new ArrayList<>();
		genericNum(zs);
		genericNum(ls);
//		genericNum(ww);
		
		generics(zs);
		generics(ls);
		generics(ww);
	}
	
	public static void genericNum(List<? extends Person> list) {
		Iterator <? extends Person> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void generics(List<?> list) {
		Iterator <?> it = list.iterator();
		while(it.hasNext()) {
			System.out.println("NO--"+it.next());
		}
	}

}
