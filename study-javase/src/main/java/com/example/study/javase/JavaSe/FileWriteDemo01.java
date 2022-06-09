package com.example.study.javase.JavaSe;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 字符输出流，写文件
 */
public class FileWriteDemo01 {

	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("H://write.txt");
		char[] c = {'a','b','v','d'};
		fw.write(c,1,2);
		fw.flush();
		fw.close();
	}
}
