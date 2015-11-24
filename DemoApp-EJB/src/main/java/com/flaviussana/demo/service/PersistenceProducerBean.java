package com.flaviussana.demo.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.some.hui.JobScheduler;
import com.some.hui.domain.Department;
import com.some.hui.domain.Stored;

@Singleton
@Startup
// @PersistenceContext(name = "persistence/InventoryAppMgr", unitName = "spain")
// @PersistenceUnit(name="myjndipu", unitName="spain")
public class PersistenceProducerBean {

	@PersistenceContext(unitName = "spain")
	EntityManager em;
	//
	// @Inject
	// EmployeeDemoSession ejb;

	// @Inject
	// EntityManager em1;

	@PersistenceUnit(name = "myjndipu", unitName = "spain")
	EntityManagerFactory emf;

	@Inject
	@Stored
	Department hui;
	
	@Inject
	SomeSession bean;

	// @Produces
	// @Spain
	// EntityManager getEm() {
	// return em;
	// }

	JobScheduler js = null;

	public PersistenceProducerBean() {
		js = new JobScheduler();

	}

	@PostConstruct
	void init() {
		System.out.println("########### init...");

		if (hui == null) {
			System.out.println("########### hujlo = null...");
		} else {
			System.out.println("########## hujlo != null...");
			System.out.println("########## hujlo nmae:" + hui.getName());
		}

		if (emf == null) {
			System.out.println("########### EntityManagerFactory = null...");
		} else {
			System.out.println("########## EntityManagerFactory != null...");
		}

		if (em == null) {
			System.out.println("########### em = null...");
		} else {
			System.out.println("########## em != null...");
		}
		
		bean.doSomething();

		// if (em1 == null) {
		// System.out.println("########### injected em = null...");
		// } else {
		// System.out.println("########## injected em != null...");
		// }

		System.out
				.println("+++++++++++++++++++++++ in PersistenceProducer HUI");
		System.out.println("########### init...");
		//try {
			//js.start();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// TestPojo pojo = new TestPojo();
		// pojo.execute();
		// ejb.doSomething();
	}

}
