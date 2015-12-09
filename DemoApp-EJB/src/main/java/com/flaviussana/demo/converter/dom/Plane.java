package com.flaviussana.demo.converter.dom;

public class Plane implements Vehicle {

	private long speed;

	private String airline;

	@Override
	public long getSpeet() {
		return speed;
	}

	@Override
	public void setSpeed(long speed) {
		this.speed = speed;

	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirline() {
		return airline;
	}

	

}
