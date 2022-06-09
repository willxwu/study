package com.example.study.javase.JavaSe;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 字节缓冲输出流
 * @author Jole
 *
 */
public class BufferedOutputStreamDemo01 {

	public static void main(String[] args) {
		try {
			bufferWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bufferWriter() throws IOException{
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("H:\\c.txt"));
		bos.write("Hello world".getBytes());
		bos.flush();
		bos.close();
	}
}
