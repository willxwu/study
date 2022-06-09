package com.example.study.javase.JavaSe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * 基于输入、输出流的文件拷贝
 * @author Jole
 *
 */
public class CopyFIleDemo {

	public static void main(String[] args) {

		copyFiles();
	}
	
	public static void copyFiles() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("H:\\1.exe");
			fos = new FileOutputStream("D:\\new1.exe");
			byte[] b = new byte[1024];
			int len =0;
			while((len=fis.read(b))!=-1) {
				fos.write(b,0,len);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("复制失败");
		}finally {
			if(null!=fos) {
				try {
					fos.close();
				}catch(Exception e) {
					throw new RuntimeException("输出流关闭失败");
				}finally {
					try {
						if(null!=fis) {
							fis.close();
						}
					}catch(Exception e) {
						System.out.println(e.getMessage());
						throw new RuntimeException("输入流关闭失败");
					}
				}
				
			}
		}
	}

}
