package com.some.hui;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.some.hui.domain.Department;
import com.some.hui.domain.EmployeeDemoSession;
import com.some.hui.domain.EmployeeDemoSessionHUI;
import com.some.hui.domain.Stored;
import com.some.hui.domain.UserManagerImpl;

public class TestJob implements Job {

	@PersistenceContext(unitName = "spain")
	EntityManager em;

	@Resource
	private UserTransaction ut;

	// @Inject
	// @Spain
	// EntityManager em22;

	@Inject
	@Stored
	Department hui;

	public void execute(JobExecutionContext jExeCtx)
			throws JobExecutionException {
		UserManager um = new UserManagerImpl();
		um.findUser();

		if (ut == null) {
			System.out.println("UserTransaction == null...");
		} else {
			System.out.println("UserTransaction != null...");
		}

		if (em == null) {
			System.out.println("em == null...");
		} else {
			System.out.println("em != null...");
		}

		if (hui == null) {
			System.out.println("hui == null...");
		} else {
			System.out.println("em != null...");
			System.out.println("Hui name:" + hui.getName());
		}
		System.out
				.println("###############################################...");
		Context initCtx = null;
		try {

			Context ctx = new InitialContext();
			EmployeeDemoSessionHUI fooRef = (EmployeeDemoSessionHUI) ctx
					.lookup("java:global/examples/foo/remote/hui");
			if (fooRef == null) {
				System.out.println("ref HUIIII->fooRef == null...");
			} else {
				System.out.println("ref HUIIIIIIII->fooRef != null...");
			}

			// ut = (UserTransaction)ct.lookup("java:comp/UserTransaction");
			// if (ut == null) {
			// System.out.println("UserTransactionhhhh == null...");
			// } else {
			// System.out.println("UserTransactionhhhh != null...");
			// }
			//
			// initCtx = new InitialContext();
			// javax.persistence.EntityManager entityManager =
			// (javax.persistence.EntityManager) initCtx
			// .lookup("spain");
			// if (entityManager == null) {
			// System.out.println("entityManager == null...");
			// } else {
			// System.out.println("entityManager != null...");
			// }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("TestJob run successfully...");
	}

}
