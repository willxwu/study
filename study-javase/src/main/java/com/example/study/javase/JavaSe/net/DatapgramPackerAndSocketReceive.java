package com.example.study.javase.JavaSe.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接收方：使用UDP协议
 * @author Jole
 * DatagramSocket：绑定端口
 * DatagramPacket：接受数据
 * 解析DatagramPacket接受到的数据
 */
public class DatapgramPackerAndSocketReceive {

	public static void main(String[] args) throws IOException{
		DatagramSocket ds = new DatagramSocket(6000);
		
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		
		ds.receive(dp);
		ds.close();
		
		InetAddress inet = dp.getAddress();
		
		System.out.println(new String(data,0,dp.getLength())+"IP:"+inet.getHostName()+":"+dp.getPort());
		
	}
}
