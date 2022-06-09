package com.example.study.javase.JavaSe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 字符缓冲输入流，独有readlin方法
 * @author Jole
 *
 */
public class BufferedReaderDemo02 {
	public static void main(String[] args) {
		try {
			bufferReadered();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bufferReadered() throws IOException{
		int n=0;
		BufferedReader br = new BufferedReader(new FileReader("H:\\zxw.txt"));
		String len =null;
		while((len = br.readLine()) != null) {
			n++;
			System.out.println(n+"\t"+len);
			
		}
		br.close();
	}
}
