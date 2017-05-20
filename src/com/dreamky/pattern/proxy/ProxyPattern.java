package com.dreamky.pattern.proxy;

/**
 * 代理模式
 * @author Administrator
 *
 */
public class ProxyPattern {
	
	public static void main(String[] args) {
		ProxyImage image = new ProxyImage("myImage");
		image.display();
		image.display();
	}

}
