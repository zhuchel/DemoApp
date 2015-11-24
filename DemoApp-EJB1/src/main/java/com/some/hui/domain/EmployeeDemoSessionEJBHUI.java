package com.some.hui.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless(name = "EmployeeDemoSessionEJBHUI", mappedName = "EmployeeDemoSessionHUI")
@EJB(name = EmployeeDemoSessionHUI.NAME, beanInterface = EmployeeDemoSessionHUI.class)
public class EmployeeDemoSessionEJBHUI implements EmployeeDemoSessionHUI {

	@PersistenceContext(unitName = "spain")
	EntityManager em;
	
	@Inject
	@Credit
	Event<PaymentEvent> credit;
	

	public void doSomething(){

		PaymentEvent creditEvent = new PaymentEvent();
		creditEvent.setName("Hujovyj moment");
		credit.fire(creditEvent);
		System.out.println("########### hujnej' ...");
		if (em == null) {
			System.out
					.println("EmployeeDemoSessionEJBHUI HUIIII->em == null...");
		} else {
			System.out
					.println("EmployeeDemoSessionEJBHUI HUIIIIIIII->em != null...");
		}
	}
}