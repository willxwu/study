package com.example.study.javase.JavaSe.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
/**
 * 利用开源工具Commons-IO中的FileUtils工具类进行文件的常规操作
 * @author Jole
 *
 */
public class CommonsIOFileUtils {

	public static void main(String[] args) throws IOException{
		//读文件
		String string = FileUtils.readFileToString(new File("H:\\zz.txt"));
		System.out.println(string);
		
		//写文件
		FileUtils.writeStringToFile(new File("H:\\cc.txt"), "Look ME");
		
		//复制文件
		FileUtils.copyFile(new File("H:\\z.txt"), new File("D:\\xx.txt"));
		
		//复制文件夹
		FileUtils.copyDirectoryToDirectory(new File("H:\\a"), new File("D:\\a"));
	}

}
