package com.flaviussana.demo.converter;


public interface VehicleConverter<T, R> {

	T convertToBom(R dom);

	R convertToDom(T bom);

}
