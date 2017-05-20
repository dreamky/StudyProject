package com.dreamky.thread;

class MyThread extends Thread {

	static int num = 100;

	public void run() {

		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + num--);
			} else {
				break;
			}
		}
	}
}

class RunThread implements Runnable {

	int num = 100;

	@Override
	public void run() {

		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + num--);
			} else {
				break;
			}
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {

		//使用继承thread
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		MyThread thread3 = new MyThread();

		thread1.start();
		thread2.start();
		thread3.start();
		
		//使用实现runnable
		RunThread run = new RunThread();
		Thread thread5 = new Thread(run);
		Thread thread6 = new Thread(run);
		Thread thread7 = new Thread(run);

		thread5.start();
		thread6.start();
		thread7.start();

	}

}
