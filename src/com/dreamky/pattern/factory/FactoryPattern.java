package com.dreamky.pattern.factory;

/**
 * 工厂模式
 * 
 * @author Administrator<br>
 * 
 * 	1.定义一个关于车的接口：ICar<br>
 * 	2.实现接口，这里包含里2个实现（BenzCar、BMWCar）<br>
 * 	3.定义工厂类：CarFactory<br>
 * 
 */
public class FactoryPattern {
	
	public static void main(String[] args) {
		
		CarFactory carFactory = new CarFactory();
		
		ICar BMWcar = carFactory.getCarCompany("BMW");
		BMWcar.productCar();
		
		ICar Benzcar = carFactory.getCarCompany("");
		Benzcar.productCar();
	}

}
