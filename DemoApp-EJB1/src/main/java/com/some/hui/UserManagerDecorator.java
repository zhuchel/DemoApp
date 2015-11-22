/**
 * @author Copyright (c) 2008,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.some.hui;

import java.io.Serializable;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.some.hui.domain.Department;
import com.some.hui.domain.UserEM;

/**
 * Decorator Class
 * 
 */
@Decorator
public class UserManagerDecorator implements UserManager, Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	@Delegate
	private UserManager delegate;
	
	@Inject
	@UserEM
	private EntityManager em;

	@Override
	public Department findUser() {
		System.out.println("########### in UserManagerDecorator ...");
		if (em == null) {
			System.out
					.println("###########  UserManagerDecorator EntityManager in UserManagerImpl null...");
		} else {
			System.out
					.println("########## UserManagerDecorator EntityManager in UserManagerImpl != null...");
		}
		return delegate.findUser();
	}

}
