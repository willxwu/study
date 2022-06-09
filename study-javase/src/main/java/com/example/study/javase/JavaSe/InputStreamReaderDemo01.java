package com.example.study.javase.JavaSe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ����ת����InputStreamReader�����ֽ���ת���ַ���
 * @author Jole
 * ���ֽ������������ڿ�������д�롢д��ʱ�ļ��ı��뼯
 */
public class InputStreamReaderDemo01 {

	public static void main(String[] args) {
		try {
			myInputStreamReader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void myInputStreamReader() throws IOException{
		FileInputStream is = new FileInputStream("H:\\zz.txt");
		InputStreamReader isr = new InputStreamReader(is, "GBK");
		int len =0;
		char[] c = new char[1024];
		while((len = isr.read(c)) != -1) {
			System.out.println(new String(c, 0 ,len));
		}
		isr.close();
	}

}
