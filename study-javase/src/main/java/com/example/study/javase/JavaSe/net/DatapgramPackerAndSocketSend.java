package com.example.study.javase.JavaSe.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * 发送方：使用UDP协议
 * 利用DatagramPacket封装要发送的数据包。
 * 利用DatagramSocket发送封装好的数据包。
 * @author Jole
 *
 */
public class DatapgramPackerAndSocketSend {
	public static void main(String[] args) {
		sendInfo();
	}
	
	public static void sendInfo() {
		byte[] info = "你好".getBytes();
		
		try {
			InetAddress inet = InetAddress.getByName("127.0.0.1");
			DatagramPacket dp = new DatagramPacket(info, info.length, inet, 6000);
			
			DatagramSocket sock = new DatagramSocket();
			sock.send(dp);
			sock.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
