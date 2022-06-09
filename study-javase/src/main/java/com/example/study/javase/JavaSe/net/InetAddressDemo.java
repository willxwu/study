package com.example.study.javase.JavaSe.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 利用InetAddress获取主机名、主机ip、以及通过计算机名称获取ip
 * @author Jole
 *
 */
public class InetAddressDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInetAddressObj();
	}
	
	public static void getInetAddressObj() {
		try {
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println(inet.getHostName()+" "+ inet.getHostAddress());
			
			InetAddress inet2 = InetAddress.getByName("DELL");
			System.out.println(inet2.getHostName()+ " "+ inet2.getHostAddress());
			
			InetAddress inet3 = InetAddress.getByName("192.168.1.4");
			System.out.println(inet3.getHostName()+ " "+ inet3.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
