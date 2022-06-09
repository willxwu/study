package com.example.study.javase.JavaSe;

import java.io.File;
/**
 * 遍历文件
 * @author Jole
 *
 */
public class SearchFIles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File  file = new File("H:\\");
		findFile(file);
		
	}
	
	public static void findFile(File file) {
		System.out.println("--"+file);
		File[] array = file.listFiles();
		for(File f : array) {
			if(f.isDirectory()) {
				findFile(f);
			}else {
				System.out.println(f);
			}
		}
	}

}
