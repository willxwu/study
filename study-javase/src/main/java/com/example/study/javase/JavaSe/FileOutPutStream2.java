package com.example.study.javase.JavaSe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 字节输出流
 * @author Jole
 *
 */
public class FileOutPutStream2 {

	public static void main(String[] args) throws IOException{

		File f = new File("H://111.txt");
		FileOutputStream fos = new FileOutputStream(f, true);
		fos.write("Hello\r\n".getBytes());
		fos.write("World".getBytes());
		fos.close();
	}

}
