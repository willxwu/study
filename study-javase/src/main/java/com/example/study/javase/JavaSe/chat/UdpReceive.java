package com.example.study.javase.JavaSe.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * UDP：接收方
 * @author Jole
 *
 */
public class UdpReceive {

	public static void main(String[] args) throws Exception{
		DatagramSocket socket = new DatagramSocket(6000);
		byte[] info = new byte[1024];
		while(true) {
			DatagramPacket pack = new DatagramPacket(info, info.length);
			socket.receive(pack);
			InetAddress ia = pack.getAddress();
			System.out.println(ia.getHostName()+"-"+pack.getPort()+":"+new String(info,0,pack.getLength()));
		}
		
	}

}
