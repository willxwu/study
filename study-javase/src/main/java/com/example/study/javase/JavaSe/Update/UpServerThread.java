package com.example.study.javase.JavaSe.Update;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
/**
 * 改造为多线程，服务端
 * @author Jole
 *
 */
public class UpServerThread implements Runnable{

	private Socket socket;
	public UpServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			//获取客户端输入流
			InputStream in = socket.getInputStream();
			
			//判断文件夹是否存在，不存在则新建
			File file = new File("H:\\up");
			if(!file.exists()) {
				file.mkdir();
			}
			//设置文件名规则
			String fileName = System.currentTimeMillis()+"_"+new Random().nextInt(9999)+".zip";
			FileOutputStream out = new FileOutputStream(file+File.separator+fileName);
			//读取客户端发送数据，并写入到H：\\up文件夹下面
			byte[] data = new byte[1024];
			int len = 0;
			while((len=in.read(data))!=-1) {
				out.write(data, 0, len);
			}
			
			//返回消息给客户端，上传成功信息
			OutputStream outInfo = socket.getOutputStream();
			outInfo.write("上传成功".getBytes());
			outInfo.close();
			out.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
