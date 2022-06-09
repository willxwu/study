package com.example.study.javase.JavaSe.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * TCP客户端Socket
 * @author Jole
 *
 */
public class Clent {

	public static void main(String[] args) throws IOException{
		Socket clent = new Socket("127.0.0.1", 8888);
		OutputStream out = clent.getOutputStream();
		out.write("你好!".getBytes());
		
		InputStream in = clent.getInputStream();
		byte[] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data, 0, len));
		clent.close();
	}

}
