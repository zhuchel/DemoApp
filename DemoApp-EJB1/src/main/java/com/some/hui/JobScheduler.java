package com.some.hui;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//@ApplicationScoped
public class JobScheduler {

	@PersistenceContext(unitName = "spain")
	EntityManager em;
	
	@PersistenceUnit(name="myjndipu", unitName="spain")
	EntityManagerFactory emf;

	public void start() throws NamingException {

		Context initCtx = new InitialContext();
		// perform JNDI lookup to obtain container-managed entity manager
//		javax.persistence.EntityManager entityManager = (javax.persistence.EntityManager) initCtx
//				.lookup("java:comp/env/persistence/InventoryAppMgr");
//		EntityManagerFactory emf = (EntityManagerFactory)initCtx.lookup("java:comp/env/myjndipu");

		if (emf == null) {
			System.out.println("########### EntityManagerFactoryentityManager =HUI = null...");
		} else {
			System.out.println("########## EntityManagerFactory != null...");
		}

		try {

			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(TestJob.class)
					.withIdentity("testJob").build();

			BeanManager beanManager = null;
			try {
				InitialContext context = new InitialContext();
				beanManager = (BeanManager) context
						.lookup("java:comp/BeanManager");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (beanManager == null) {
				System.out.println("########### beanManager == null...");
			} else {
				System.out.println("########## beanManager != null...");
			}
			Class<? extends JobDetail> clazz = job.getClass();

			if (beanManager != null) {
				CreationalContext<JobDetail> ctx = beanManager
						.createCreationalContext(null);

				@SuppressWarnings("unchecked")
				AnnotatedType<JobDetail> type = (AnnotatedType<JobDetail>) beanManager
						.createAnnotatedType(clazz);

				InjectionTarget<JobDetail> it = beanManager
						.createInjectionTarget(type);

				it.inject(job, ctx);
				System.out.println("########### injection created...");
			}

			// specify the running period of the job
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(30).repeatForever())
					.build();

			// schedule the job
			SchedulerFactory schFactory = new StdSchedulerFactory();
			Scheduler sch = schFactory.getScheduler();
			sch.start();
			sch.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
