/**
 * @author Copyright (c) 2010,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.flaviussana.demo;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

@Stateless
@BeanCounter
public class AccountManager {

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
		logger.debug("########## is this from logback?");
		logger.info("######### in findAccount");
		Account account = new Account();
		account.setName("HUI");
		account.setAmount(12.0f);
		return account;
	}
}
