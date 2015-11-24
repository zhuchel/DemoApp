package com.flaviussana.demo.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.some.hui.domain.Credit;
import com.some.hui.domain.PaymentEvent;

public class EventProducer {

	@Inject
	@Credit
	Event<PaymentEvent> credit;

	public void produce() {

		PaymentEvent creditEvent = new PaymentEvent();
		creditEvent.setName("Hujovyj moment");
		credit.fire(creditEvent);
		System.out.println("########### hujnej' ...");

	}
}