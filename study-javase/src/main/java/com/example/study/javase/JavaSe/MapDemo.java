package com.example.study.javase.JavaSe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * ��Ҫ
 * ����map�����ַ�ʽmap.entrySet()   map.keySet()
 * @author Jole
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		Map<Integer ,String > map = new HashMap();
		map.put(1, "111");
		map.put(2, "2222");
		
		//��ʽһ entrySet()
		Set<Map.Entry <Integer, String>> sets = map.entrySet();
		//��ȡֵ1��ͨ��for
		for(Map.Entry <Integer, String> entry : sets) {
			System.out.println("ssss:"+entry);
			System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
		}
		
		//��ȡֵ2��ͨ��iterator
		Iterator <Map.Entry <Integer, String>> itt = sets.iterator();
		while(itt.hasNext()) {
			Map.Entry <Integer, String> entrys = itt.next();
			System.out.println(entrys.getKey()+"----"+entrys.getValue());
		}
		
		
		System.out.println(map.put(3, "222"));
		
		
		//��ʽ��  keySet()
		Set<Integer> set = map.keySet();
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println("Iterator="+it.next());
			System.out.println("key:"+map.get(it.next()));
		}
	    for(Integer in : set) {
	    	System.out.println(in);
	    }
		
		
	}
}
