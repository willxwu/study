package com.example.study.javase.JavaSe;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 字节输出流，写入文件
 * @author Jole
 *
 */
public class FileOutpuStream {

	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("H://fileoutputstream.txt");
		fos.write(2014);
		byte[] b = {66,67,68,69};
		fos.write(b);
		fos.write(b,1,2);
		fos.write("Hello World".getBytes());
		fos.close();
	}

}
