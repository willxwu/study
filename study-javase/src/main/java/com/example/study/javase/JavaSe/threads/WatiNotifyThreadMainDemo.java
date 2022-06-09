package com.example.study.javase.JavaSe.threads;
/**
 * 线程等待、唤醒：
 * 涉及同步锁是否是同一个锁，只有锁调用wait和notify才有效，不然抛出异常。
 * 正常情况是交替出现，不会出现数据错乱情况。
 * @author Jole
 * 本类是主测试类
 * 该实例：input拷贝数据对象，output输入对象：
 * input可能出现拷贝对象拷贝很快，output输出对象很慢，导致output输出数据错乱，因此只能单个拷贝输出，且每次拷贝完后需wait等待，然后等输出完成后在拷贝。
 * 因此需要拷贝完成后，等待，并唤醒输出，等输出完成前唤醒拷贝，然后自己在等待，然后拷贝又拷贝，然后又唤醒输出，如此循环。
 * 实现方法加一个flag标记，是该拷贝还是输出
 */
public class WatiNotifyThreadMainDemo {

	public static void main(String[] args) {
		//操作的是同一个对象锁，不然拷贝和输出都是用自己的锁this，也会发生数据错乱
		ResourceData resource = new ResourceData();
		
		//保证是同一个锁对象，所以都写了构造方法传入同一个锁对象
		InputDemo input = new InputDemo(resource);
		OutputDemo output = new OutputDemo(resource);
		
		Thread t0 = new Thread(input);
		Thread t1 = new Thread(output);
		
		t0.start();
		t1.start();
	}

}
