package com.flaviussana.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.flaviussana.demo.converter.ConverterFactory;
import com.flaviussana.demo.converter.bom.Plane;
import com.tangosol.net.CacheFactory;

@Stateless
@WebService(name = "SomeSupport", serviceName = "financeSupport", targetNamespace = "http://some.com/service/finance")
@Addressing(enabled = false, required = false)
public class SomeSupportSF {
	
	@Inject
	ConverterFactory<Plane, com.flaviussana.demo.converter.dom.Plane> factory;
	
	private String[] test;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@WebMethod(operationName = "getCacheManagerInformation", action = "urn:getCacheManagerInformation")
	public List<CacheManagerInformation> getCacheManagerInformation() {
		CacheFactory.getCache("hello-example");
		final List<CacheManagerInformation> result = new ArrayList<CacheManagerInformation>();
		System.out.println("################## huiiiiiiiiiiii");
		return result;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@WebMethod(operationName = "getHui", action = "urn:getHui")
	public HuiResponse getHui() {
	
		com.flaviussana.demo.converter.dom.Plane plane = new com.flaviussana.demo.converter.dom.Plane();
		plane.setAirline("airline");
		Plane converted = factory.convert(plane);
		
		HuiResponse response = new HuiResponse();
		List<CacheInformation> list = new ArrayList<CacheInformation>();
		CacheInformation info = new CacheInformation();
		info.setCacheMemoryStoreSize(100L);
		info.setCacheStatus("pCacheStatus");

		CacheInformation info1 = new CacheInformation();
		Map<Object, Object> cacheContent = new HashMap<Object, Object>();
		cacheContent.put("hj", "ssdf");
		info1.setCacheContent(cacheContent);
		info1.setCacheMemoryStoreSize(200L);
		info1.setCacheStatus("pCacheStatus88");

		list.add(info);
		list.add(info1);
		ListHolder holder = new ListHolder();
		holder.setList(list);
		Map<String, ListHolder> map = new HashMap<String, ListHolder>();
		map.put("hui", holder);
		response.setMap(map);
		return response;
	}
	
	public void getHui1(String[] test) {
		this.test = test;
	}
	
	public void getHui2(String[] test) {
		this.test = test;
	}
	
	public void getHui3(String[] test) {
		this.test = test;
	}
	
	public void getHui4(String[] test) {
		this.test = test;
	}
	
	public void getHui5(String[] test) {
		this.test = test;
	}
	
	public void getHui6(String[] test) {
		this.test = test;
	}
	
	public void getHui7(String[] test) {
		this.test = test;
	}
	
	public void getHui8(String[] test) {
		this.test = test;
	}
	
	public void getHui9(String[] test) {
		this.test = test;
	}
}
