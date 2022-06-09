package com.example.study.javase.JavaSe.threads;
/**
 * 拷贝线程：
 * 当标记flag=true时，拷贝完成，需等待
 * @author Jole
 *
 */
public class InputDemo implements Runnable {
	private ResourceData resourceData;
	public InputDemo(ResourceData resourceData) {
		this.resourceData = resourceData;
	}

	@Override
	public void run() {
		int  number=0;
		while(true) {
			synchronized (resourceData) {
				//如果为ture拷贝完成，需等待
				if(resourceData.flag) {
					try {
						resourceData.wait();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				//拷贝值，比如写死拷贝张三,30岁，lishi，20岁
				if(number % 2==0) {
					resourceData.name = "张三";
					resourceData.sex = "男";
				}else {
					resourceData.name = "Lishi";
					resourceData.sex = "nv";
				}
				
				//设置true，以便下次进入等待wait
				resourceData.flag = true;
				
				//唤醒输出线程
				resourceData.notify();
			}
			
			number++;
		}

	}

}
