package com.example.study.javase.JavaSe.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * TCP 服务端ServerSOCKET
 * @author Jole
 *
 */
public class Server {

	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		byte[] data= new byte[1024];
		int len =in.read(data) ;
		
		OutputStream out = socket.getOutputStream();
		out.write("欢迎访问".getBytes());
		
		in.close();
		socket.close();
		server.close();
		System.out.println(new String(data,0,len));
		
	}

}
