package com.dreamky.pattern.singleton;

/**
 * 单例模式
 * @author Administrator
 *
 */
public class SingletonPattern {
	
	public static void main(String[] args) {
		//若放开synchronized()，则最终可能会输出"创建Singleton!" 三次，模拟还原被多次实例化
		new Thread(){
			@Override
			public void run() {
				Singleton instance = Singleton.getInstance();
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				Singleton instance = Singleton.getInstance();
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				Singleton instance = Singleton.getInstance();
			}
		}.start();

	}

}
