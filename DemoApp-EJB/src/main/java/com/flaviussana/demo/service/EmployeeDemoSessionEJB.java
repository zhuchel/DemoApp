package com.flaviussana.demo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;

import com.some.hui.domain.EmployeeDemoSession;

@PersistenceContext(name = "helperPC", unitName = "spain")
@Stateless(name = "EmployeeDemoSessionEJB", mappedName = "EmployeeDemoSession")
@EJB(name = "java:global/examples/foo/remote", beanInterface = EmployeeDemoSession.class)
public class EmployeeDemoSessionEJB implements EmployeeDemoSession {
	
	//see https://blogs.oracle.com/kensaks/entry/application_specified_portable_jndi_names
	
	@PersistenceContext(unitName = "spain")
	EntityManager em;

	public void doSomething() {
		// TestPojo pojo = new TestPojo();
		// pojo.execute();
		System.out.println("########### hujnej' ...");
		if (em == null) {
			System.out
					.println("EmployeeDemoSessionEJB HUIIII->em == null...");
		} else {
			System.out
					.println("EmployeeDemoSessionEJB HUIIIIIIII->em != null...");
		}
	}
}