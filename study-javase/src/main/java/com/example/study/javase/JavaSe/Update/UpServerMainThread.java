package com.example.study.javase.JavaSe.Update;

import java.net.ServerSocket;
import java.net.Socket;
/**
 * 启动服务器多线程
 * @author Jole
 *
 */
public class UpServerMainThread {
	public static void main(String[] args) throws Exception{
		ServerSocket server  = new ServerSocket(8888);
		while(true) {
			Socket socket = server.accept();
			new Thread(new UpServerThread(socket)).start();
		}
	}
}
