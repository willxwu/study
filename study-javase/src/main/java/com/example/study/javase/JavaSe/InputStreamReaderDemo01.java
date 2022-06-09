package com.example.study.javase.JavaSe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 利用转换流InputStreamReader：将字节流转成字符流
 * @author Jole
 * 与字节流的区别在于可以设置写入、写出时文件的编码集
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
