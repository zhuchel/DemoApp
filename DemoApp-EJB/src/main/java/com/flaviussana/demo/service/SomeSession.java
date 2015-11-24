package com.flaviussana.demo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.some.hui.domain.Credit;
import com.some.hui.domain.NewEventProducer;
import com.some.hui.domain.PaymentEvent;

@Stateless
public class SomeSession  {

	@PersistenceContext(unitName = "spain")
	EntityManager em;
	
	@Inject
	NewEventProducer producer;
	
//	@Inject
//	@Credit
//	Event<PaymentEvent> credit;
	

	public void doSomething(){

		producer.produce();
//		PaymentEvent creditEvent = new PaymentEvent();
//		creditEvent.setName("Hujovyj moment");
//		credit.fire(creditEvent);
		System.out.println("########### hujnej' ...");
		
	}
	
	public void getPayment(@Observes @Credit PaymentEvent event) {
		System.out.println("++++++++++ Gott HOOK EJB Event:" + event.getName());

	}
}