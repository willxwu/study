package com.example.study.javase.JavaSe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 输出流异常处理
 * @author Jole
 *
 */
public class IoTryCatch {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			File f = new File("H://222.txt");
			fos = new FileOutputStream(f, true);
			fos.write("Hello\r\nWorld".getBytes());
		}catch(IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("写入失败，请重试");
		}finally {
			if(null!=fos) {
				try {
					fos.close();
				}catch(IOException ex) {
					System.out.println(ex.getMessage());
					throw new RuntimeException("关闭失败");
				}
			}
		}
	}

}
