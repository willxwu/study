package com.example.study.javase.JavaSe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * 重要
 * 集合的2中遍历方式：1、for循环遍历 2、iterator迭代器循环
 * @author Jole
 *
 */
public class MyIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		Object[] obj = list.toArray();
		//for循环遍历
		for(Object o : obj) {
			System.out.println("111-"+o);
		}
		
		for(int i=0;i<obj.length;i++) {
			System.out.println("=="+obj[i]);
		}
		
		Set<String> set = new HashSet<>();
		set.add("a111");
		set.add("b222");
		set.add("c333");
		set.add("d444");
		set.add("d444");
		
		//iterator迭代器循环
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(String str : list) {
			System.out.println("for"+str+'=');
		}
	}

}
