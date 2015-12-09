package com.flaviussana.demo.converter;

import com.flaviussana.demo.converter.bom.Car;

public class CarConverter implements
		VehicleConverter<Car, com.flaviussana.demo.converter.dom.Car> {

	@Override
	public Car convertToBom(com.flaviussana.demo.converter.dom.Car dom) {
		Car car = new Car();
		car.setBrand(dom.getBrand());
		car.setSpeed(dom.getSpeet());
		return car;
	}

	@Override
	public com.flaviussana.demo.converter.dom.Car convertToDom(Car bom) {
		com.flaviussana.demo.converter.dom.Car car = new com.flaviussana.demo.converter.dom.Car();
		car.setBrand(bom.getBrand());
		car.setSpeed(bom.getSpeet());
		return car;
	}

}
