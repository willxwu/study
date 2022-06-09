package com.example.study.javase.JavaSe.threads;
/**
 * 输出线程：
 * 当标记flag=false时，输出完成，需等待
 * @author Jole
 *
 */
public class OutputDemo implements Runnable {
	
	private ResourceData resourceData;
	public OutputDemo(ResourceData resourceData) {
		this.resourceData = resourceData;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (resourceData) {
				//如果为false，则输出完成，等待
				if(!resourceData.flag) {
					try {
						resourceData.wait();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				//否则输出，并唤醒拷贝
				System.out.println(resourceData.name+" .. "+ resourceData.sex);
				resourceData.flag = false;
				resourceData.notify();
			}
		}
	}

}
