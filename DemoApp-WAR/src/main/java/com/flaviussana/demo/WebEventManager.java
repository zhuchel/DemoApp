/**
 * @author Copyright (c) 2010,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.flaviussana.demo;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.some.hui.UserManager;
import com.some.hui.domain.Credit;
import com.some.hui.domain.PaymentEvent;

public class WebEventManager  {
	
	public void getPayment(@Observes @Credit PaymentEvent event) {
		System.out.println("++++++++++ Gott WEB Event:" + event.getName());

	}
}
