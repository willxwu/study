package com.example.study.javase.JavaSe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * ���ô�ӡ�������ļ�����ƴ�ӡ�����Զ�ˢ�£��������֧���Զ�ˢ�£�File���ַ�����֧���Զ�ˢ�£�
 * PrintStream\PrintWriter
 * @author Jole
 *
 */
public class PrintLiu {

	public static void main(String[] args) throws IOException{
		copyFiles();
	}
	
	public static void copyFiles() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("H:\\zz.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("D:\\zz.txt"));
		String len = null;
		while((len = br.readLine()) != null) {
			pw.println(len);
		}
		pw.close();
		br.close();
	}

}
