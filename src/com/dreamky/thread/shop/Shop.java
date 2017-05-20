package com.dreamky.thread.shop;

/**
 * 
 * @author Administrator
 *
 *         生产者、消费者问题 : <br>
 *         生产者(Productor)将产品交给店员(Clerk)， 而消费者(Customer)从店员处取走产品<br>
 *         店员一次只能持有固定数量的产品(比如:20）， 如果生产者试图生产更多的产品，店员会叫生产者停一下<br>
 *         如果店中有空位放产品了再通知生产者继续生产； 如果店中没有产品了，店员会告诉消费者等一下， 如果店中有产品了再通知消费者来取走产品。
 * 
 */
public class Shop {

	public static void main(String[] args) {

		Production production = new Production(0);
		Productor productor = new Productor(production);
		Customer customer = new Customer(production);
		Thread productorThread = new Thread(productor);
		Thread customerThread = new Thread(customer);

		productorThread.start();
		customerThread.start();

	}

}

class Productor implements Runnable {

	Production p;

	Productor(Production p) {

		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((int) (Math.random() * 1000));
				p.addP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Customer implements Runnable {

	Production p;

	Customer(Production p) {
		this.p = p;
	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep((int) (Math.random() * 1000));
				p.redP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Production {

	private int p;

	public Production(int p) {
		this.p = p;
	}

	int getP() {
		return p;
	}

	public synchronized int addP() throws InterruptedException {
		System.out.print("店员拿了商品，目前共有商品：" + ++p);
		if (p > 20) {
			System.out.println("，店中商品过多，请稍后生产");
			wait();
		} else {
			System.out.println("，店中目前剩余商品：" + p + "请继续生产");
			notifyAll();
		}
		return p;
	}

	public synchronized int redP() throws InterruptedException {
		System.out.print("店员给了商品，目前共有商品：" + --p);
		if (p < 1) {
			System.out.println("，店中已没有商品，请等待");
			wait();
		} else {
			System.out.println("，店中目前剩余商品：" + p + "可继续购买");
			notifyAll();
		}
		return p;
	}
}
