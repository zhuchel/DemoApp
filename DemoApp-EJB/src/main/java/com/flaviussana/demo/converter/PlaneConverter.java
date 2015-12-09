package com.flaviussana.demo.converter;

import com.flaviussana.demo.converter.bom.Plane;

public class PlaneConverter implements
		VehicleConverter<Plane, com.flaviussana.demo.converter.dom.Plane> {

	@Override
	public Plane convertToBom(com.flaviussana.demo.converter.dom.Plane dom) {
		Plane plane = new Plane();
		plane.setAirline(dom.getAirline());
		plane.setSpeed(dom.getSpeet());
		return plane;
	}

	@Override
	public com.flaviussana.demo.converter.dom.Plane convertToDom(Plane bom) {
		com.flaviussana.demo.converter.dom.Plane plane = new com.flaviussana.demo.converter.dom.Plane();
		plane.setAirline(bom.getAirline());
		plane.setSpeed(bom.getSpeet());
		return plane;
	}

}
