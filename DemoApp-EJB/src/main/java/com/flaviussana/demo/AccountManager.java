/**
 * @author Copyright (c) 2010,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.flaviussana.demo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.some.hui.SomeHui;
import com.some.hui.domain.Department;
import com.some.hui.hibernate.HibernateUtil;

@Stateless
@BeanCounter
public class AccountManager {
	
	@Inject
	private SomeHui hui;
	
	@PersistenceContext(unitName = "spain")
	EntityManager em;

	private static Logger logger = LoggerFactory
			.getLogger(AccountManager.class);

	// @PersistenceContext
	// private EntityManager em;

	public void depositOnAccount(String name, float amount) {
		Account account = new Account();
		account.setName(name);
		account.setAmount(account.getAmount() + amount);

	}

	public Account findAccount(String name) {
		
//		Object obj = LoggerFactory.getILoggerFactory();
//		System.out.println("########################### factory class:"
//				+ obj.getClass().getCanonicalName());
//		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//		JoranConfigurator configurator = new JoranConfigurator();
//		configurator.setContext(lc);
//		lc.stop();

		System.out.println("########################### hier");
		System.out.println("########################### hui:" + hui.getHui());
		logger.debug("########## is this from logback?");
		logger.info("######### in findAccount");
		
		
		Account account = new Account();
		account.setName("HUI");
		account.setAmount(12.0f);
		return account;
	}
	
	public Department createDepartment() {
		Department dep = new Department();
		dep.setId(System.currentTimeMillis());
		dep.setName("name from JPA");
		em.persist(dep);
		return dep;
	}
	
	public Department createDepartmentHibernate() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Department princess = new Department();
		princess.setId(System.currentTimeMillis());
		princess.setName("Princess");
		session.save(princess);
		tx.commit();
		HibernateUtil.closeSession();
		return princess;
	}
}
