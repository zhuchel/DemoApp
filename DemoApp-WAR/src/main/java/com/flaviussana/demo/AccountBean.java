/**
 * @author Copyright (c) 2008,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.flaviussana.demo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.flaviussana.demo.interceptor.OnDeposit;
import com.some.hui.domain.Department;
import com.some.service.finance.FinanceSupport;
import com.some.service.finance.SomeSupport;

/**
 * CDI Managed Bean Class
 */
@Named
@RequestScoped
public class AccountBean {

	private String name;

	private float amount;

	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@BeanCounter
	@Inject
	private AccountManager accountManager;

	@Inject
	FinanceSupport support;

	@OnDeposit
	public void deposit() {
		accountManager.depositOnAccount(name, amount);
		Account account = accountManager.findAccount(name);
		msg = "The money have been deposited to " + account.getName()
				+ ", the balance of the account is " + account.getAmount();
	}

	public void callService() {
		System.out.println("########### in callService");
		SomeSupport port = support.getSomeSupportPort();
		port.getCacheManagerInformation();
	}

	public void createJpaDep() {
		System.out.println("########### in createJpaDep");
		Department dep = accountManager.createDepartment();
		System.out.println("########### created JpaDep:" + dep.getId());
	}
	
	public void createHibernateDep() {
		System.out.println("########### in createJpaDep");
		Department dep = accountManager.createDepartmentHibernate();
		System.out.println("########### created JpaHibernate:" + dep.getId());
	}
}
