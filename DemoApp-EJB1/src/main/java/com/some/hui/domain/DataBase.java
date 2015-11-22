/**
 * @author Copyright (c) 2010 by Oracle. All Rights Reserved
 *  
 */
package com.some.hui.domain;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataBase {
	@Produces
	@PersistenceContext
	@UserEM
	EntityManager userDatabaseEntityManager;
}
