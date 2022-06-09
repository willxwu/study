package com.example.study.javase.JavaSe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 利用字符输入流、字符输出流拷贝文本文件
 * @author Jole
 *
 */
public class CopyTxtFile {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("H:\\write.txt");
			fw = new FileWriter("I:\\copytxt.txt");
			char[] c = new char[1024];
			int len =0;
			while((len = fr.read(c)) != -1) {
				fw.write(c, 0, len);
				fw.flush();
			}
			System.out.println("文本文件复制成功");
		}catch(Exception e) {
			throw new RuntimeException("复制失败，请重试!");
		}finally {
			if(null != fw) {
				try {
					fw.close();
				}catch(IOException e) {
					throw new RuntimeException("字符输入流关闭失败！");
				}finally {
					if(null != fr) {
						try {
							fr.close();
						}catch(IOException e) {
							throw new RuntimeException("字符输出流关闭失败！");
						}
					}
				}
			}
		}
	}
}
