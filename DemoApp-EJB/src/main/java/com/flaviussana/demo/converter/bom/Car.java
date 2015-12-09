package com.flaviussana.demo.converter.bom;

public class Car implements Vehicle {

	private long speed;

	private String brand;

	@Override
	public long getSpeet() {
		return speed;
	}

	@Override
	public void setSpeed(long speed) {
		this.speed = speed;

	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

}
