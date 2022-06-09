package com.example.study.javase.JavaSe;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
/**
 * 转换流OutputStreamWriter输出文件：将字符流转成字节流
 * @author Jole
 *
 */
public class FileOutputStreamWriterDemo11 {

	public static void main(String[] args) {
		try {
			fileOutputStreamWriteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOutputStreamWriteFile() throws IOException{
		FileOutputStream fos = new FileOutputStream("H:\\zz.txt");
		OutputStreamWriter fow = new OutputStreamWriter(fos, "GBK");
		fow.write("Hello World");		
		fow.flush();
		fow.close();
	}
}
