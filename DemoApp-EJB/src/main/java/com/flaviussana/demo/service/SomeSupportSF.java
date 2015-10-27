package com.flaviussana.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.tangosol.net.CacheFactory;

@Stateless
@WebService(name = "SomeSupport", serviceName = "financeSupport", targetNamespace = "http://some.com/service/finance")
@Addressing(enabled = false, required = false)
public class SomeSupportSF {

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@WebMethod(operationName = "getCacheManagerInformation", action = "urn:getCacheManagerInformation")
	public List<CacheManagerInformation> getCacheManagerInformation() {
		CacheFactory.getCache("hello-example");
		final List<CacheManagerInformation> result = new ArrayList<CacheManagerInformation>();
		System.out.println("################## huiiiiiiiiiiii");
		return result;
	}

}
