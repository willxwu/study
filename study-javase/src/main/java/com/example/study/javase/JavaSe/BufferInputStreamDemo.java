package com.example.study.javase.JavaSe;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 字节缓冲输入流，读取文件
 * @author Jole
 *
 */
public class BufferInputStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			bufferInputTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bufferInputTxt() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("H:\\c.txt"));
		byte[]  b = new byte[1024];
		int len =0;
		while((len = bis.read(b)) != -1) {
			System.out.print(new String(b, 0 , len));
		}
	}

}
