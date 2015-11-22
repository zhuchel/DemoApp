package com.flaviussana.demo.service;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import com.some.hui.domain.EmployeeDemoSession;

@Named
@ApplicationScoped
public class TestPojo {

	@PersistenceContext(unitName = "spain")
	EntityManager em;

	@PersistenceUnit(name = "myjndipu", unitName = "spain")
	EntityManagerFactory emf;

	@Resource
	private UserTransaction ut;

	public void execute() {

		if (ut == null) {
			System.out.println("TestJob->java-yUserTransaction == null...");
		} else {
			System.out.println("TestJob.java->UserTransaction != null...");
		}

		if (em == null) {
			System.out.println("TestJob.java->em == null...");
		} else {
			System.out.println("TestJob.java->em != null...");
		}

		if (emf == null) {
			System.out.println("TestJob.java->emf == null...");
		} else {
			System.out.println("TestJob.java->emf != null...");
		}

		System.out
				.println("###############################################...");
		Context initCtx = null;
	//	try {

			

//			Context ctx = new InitialContext();
//			EmployeeDemoSession fooRef  = (EmployeeDemoSession) 
//			   ctx.lookup("java:global/examples/foo/remote");
//			if (fooRef == null) {
//				System.out
//						.println("ref HUIIII->fooRef == null...");
//			} else {
//				System.out
//						.println("ref HUIIIIIIII->fooRef != null...");
//			}
//			fooRef.doSomething();
//			EmployeeDemoSessionEJB h = (EmployeeDemoSessionEJB) PortableRemoteObject
//					.narrow(ref, EmployeeDemoSessionEJB.class);
//			h.doSomething();

//			initCtx = new InitialContext();
//			javax.persistence.EntityManager entityManager = (javax.persistence.EntityManager) initCtx
//					.lookup("java:comp/env/helperPC");
//			if (entityManager == null) {
//				System.out
//						.println("TestJob.java HUIIII->entityManager == null...");
//			} else {
//				System.out
//						.println("TestJob.java HUIIIIIIII->entityManager != null...");
//			}
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.out.println("TestPojo run successfully...");
	}

}
