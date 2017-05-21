package com.dreamky.pattern.factory;

public class CarFactory {

	public ICar getCarCompany(String carCompangy) {
		ICar car = null;
		if ("BMW".equals(carCompangy)) {
			car = new BMWCar();
		} else if ("Benz".equals(carCompangy)) {
			car = new BenzCar();
		}
		return car;
	}
}
