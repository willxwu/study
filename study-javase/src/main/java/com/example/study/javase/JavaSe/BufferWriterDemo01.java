package com.example.study.javase.JavaSe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 字符缓冲输出流，独有writeLine()换行与平台无关
 * @author Jole
 *
 */
public class BufferWriterDemo01 {

	public static void main(String[] args) {
		try {
			bufferWrited();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bufferWrited() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\zxw.txt"));
		bw.write("Hello World");
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
