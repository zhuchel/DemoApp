package com.flaviussana.demo.converter;

import org.junit.Before;
import org.junit.Test;

import com.flaviussana.demo.converter.bom.Plane;

public class ConverterTest {

	ConverterFactory<Plane, com.flaviussana.demo.converter.dom.Plane> factory;

	@Before
	public void setup() {
		factory = new ConverterFactory<Plane, com.flaviussana.demo.converter.dom.Plane>();
		factory.init();
	}

	@Test
	public void test() throws InterruptedException {
		Plane plane = new Plane();
		plane.setAirline("Lüfthansa");
		plane.setSpeed(2500);
		com.flaviussana.demo.converter.dom.Plane converted = factory
				.convert(plane);
		assert (converted != null);

	}

}
