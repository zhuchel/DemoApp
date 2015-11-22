/**
 * @author Copyright (c) 2010,2013, Oracle and/or its affiliates. All rights reserved.
 *  
 */
package com.some.hui.domain;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.some.hui.UserManager;

public class UserManagerImpl implements UserManager {
	@Inject
	@UserEM
	private EntityManager em;

	@Produces
	@Stored
	public Department findUser() {
		
		Department user = new Department();
		user.setName("Hujlo");
		return user;
	}
}
