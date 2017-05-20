package com.dreamky.pattern.singleton;

public class Singleton {

	// 单例模式的关键代码：构造一个私有函数
	private Singleton() {
		System.out.println("创建Singleton!");
	};

	private static Singleton singleton ;

	// 加上同步锁， 防止多线程同时进入造成 instance 被多次实例化
	//懒汉式
	public static Singleton getInstance() {
		synchronized (Singleton.class) {
			if (singleton == null) {
				//增加sleep()，增加去锁以后多次实例化的概率
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				singleton = new Singleton();
			}
		}
		return singleton;

	}

}
