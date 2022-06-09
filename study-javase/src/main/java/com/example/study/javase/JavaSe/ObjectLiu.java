package com.example.study.javase.JavaSe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 利用对戏那个输入输出流，进行序列化与反序列化
 * 实现Serializable接口的目的是为了可以被序列化，
 * transient关键字标记的标量 不会被序列化
 * @author Jole
 *
 */
public class ObjectLiu {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		//序列化
//		objectOutputStreamInfo();
		//反序列化
		objectinputStreamInfo();
	}
	
	
	public static void objectOutputStreamInfo() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("H:\\z2.txt"));
		Persion persion = new Persion("zhangsan",30);
		oos.writeObject(persion);
		oos.close();
	}
	
	public static void objectinputStreamInfo() throws IOException,ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("H:\\z2.txt"));
		Persion persion = (Persion)ois.readObject();
		System.out.println(persion);
		ois.close();
	}

}
