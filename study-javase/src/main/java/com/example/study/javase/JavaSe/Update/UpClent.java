package com.example.study.javase.JavaSe.Update;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 利用TCP的Socket\ServerSocket客户端向服务器上传文件
 * 客户端
 * @author Jole
 *
 */
public class UpClent {

	public static void main(String[] args) throws IOException{
		Socket socket =  new Socket("127.0.0.1",8888);
		OutputStream out = socket.getOutputStream();
		
		//读取本地文件，并通过out输出流，发送给服务端
		File file = new File("J:"+File.separator+"wxhandbook-master.zip");
		FileInputStream in = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len =0;
		while((len=in.read(data))!=-1) {
			out.write(data, 0, len);
		}
		socket.shutdownOutput();

		//获取服务器返回信息
		InputStream info = socket.getInputStream();
		int infoSize=info.read(data);
		System.out.println(new String(data, 0, infoSize));
		
		info.close();
		socket.close();
	}

}
