package com.example.study.javase.JavaSe.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 控制台输入；实现聊天。
 * 发送方
 * @author Jole
 *
 */
public class UdpSend {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		InetAddress ia = InetAddress.getByName("192.168.1.4");
		DatagramSocket socket = new DatagramSocket();
		while(true) {
			String chatInfo = scan.nextLine();
			byte[] info = chatInfo.getBytes();
			DatagramPacket pack = new DatagramPacket(info, info.length, ia, 6000);
			
			socket.send(pack);
		}
	}

}
