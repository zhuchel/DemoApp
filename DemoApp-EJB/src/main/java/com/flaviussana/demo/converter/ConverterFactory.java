package com.flaviussana.demo.converter;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.flaviussana.demo.converter.bom.Car;
import com.flaviussana.demo.converter.bom.Plane;
import com.flaviussana.demo.converter.dom.Vehicle;

public class ConverterFactory<T extends com.flaviussana.demo.converter.bom.Vehicle, R extends Vehicle> {

	private Map<String, VehicleConverter<T, R>> map = new HashMap<String, VehicleConverter<T, R>>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map.put(Car.class.getSimpleName(), (VehicleConverter<T, R>) new CarConverter());
		map.put(Plane.class.getSimpleName(),
				(VehicleConverter<T, R>) new PlaneConverter());
	}

	public R convert(T bom) {
		return map.get(bom.getClass().getSimpleName()).convertToDom(bom);
	}

	public T convert(R dom) {
		return map.get(dom.getClass().getSimpleName()).convertToBom(dom);
	}

}
