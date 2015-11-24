package com.some.hui.domain;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.some.hui.domain.Credit;
import com.some.hui.domain.PaymentEvent;

public class NewEventProducer {

	@Inject
	@Credit
	Event<PaymentEvent> credit;

	public void produce() {

		PaymentEvent creditEvent = new PaymentEvent();
		creditEvent.setName("NEW PRODUCER Hujovyj moment");
		credit.fire(creditEvent);
		System.out.println("########### hujnej' ...");

	}
}