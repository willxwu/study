package com.example.study.javase.JavaSe;

import java.io.File;
import java.io.FileFilter;
/**
 * �����ļ�������ɸѡ�ļ�FileFilter
 * @author Jole
 *
 */
public class MyFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(".java");
	}
	

}
