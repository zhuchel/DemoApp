package com.some.hui.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;

@Stateless(name = "EmployeeDemoSessionEJBHUI", mappedName = "EmployeeDemoSessionHUI")
@EJB(name = "java:global/examples/foo/remote/hui", beanInterface = EmployeeDemoSessionHUI.class)
public class EmployeeDemoSessionEJBHUI implements EmployeeDemoSessionHUI {
	
	@PersistenceContext(unitName = "spain")
	EntityManager em;

	public void doSomething() {
		
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