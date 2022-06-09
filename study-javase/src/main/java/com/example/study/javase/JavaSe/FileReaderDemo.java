package com.example.study.javase.JavaSe;

import java.io.FileReader;
import java.io.IOException;
/**
 * 字符输入流，读取文件
 * @author Jole
 *
 */
public class FileReaderDemo {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("H:\\write.txt");
		char[] c = new char[1024];
		int len =0;
		while((len = fr.read(c)) != -1) {
			System.out.println(new String(c, 0, len));
		}
		fr.close();
	}

}
