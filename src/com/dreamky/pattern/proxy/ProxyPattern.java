package com.dreamky.pattern.proxy;

/**
 * 代理模式
 * 
 * @author Administrator<br>
 * 
 * 	1.定义一个image 接口：Image<br>
 * 	2.实现接口：RealImage<br>
 * 	3.定义一个代理：ProxyImage<br>
 * 
 */
public class ProxyPattern {
	
	public static void main(String[] args) {
		ProxyImage image = new ProxyImage("myImage");
		image.display();
		image.display();
	}

}
