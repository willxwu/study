package com.example.study.javase.JavaSe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 利用字节输入输出流拷贝文件
 * @author Jole
 *
 */
public class FileInPutStream02 {

	public static void main(String[] args) {

//		try {
//			getLdfdas();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		getAll();
	}
	
	private static void getLdfdas() throws IOException{
		FileInputStream fis = new FileInputStream("H:\\222.txt");
		//创建字节数组
		byte[] b = new byte[1024];
		
		int len = 0 ;
		while( (len = fis.read(b)) !=-1){
			System.out.print(new String(b,0,len));
		}
		fis.close();
	}

	public static void getAll() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("H:\\222.txt");
			byte[] b = new byte[1024];
			
			int len = 0;
			while( (len = fis.read(b)) !=-1) {
				System.out.println(new String(b,0,len));
			}
		}catch(IOException e) {
			throw new RuntimeException("读取失败，请重试");
		}finally {
			try {
				fis.close();
			}catch(IOException ex) {
				throw new RuntimeException("流关闭失败");
			}
			
		}
	}
}
