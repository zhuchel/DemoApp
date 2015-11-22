package com.flaviussana.demo;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.some.hui.JobScheduler;

public class StartupService extends HttpServlet {

	/**
*
*/
	private static final long serialVersionUID = 1L;

	/**
*
*/
	public void init(ServletConfig config) throws ServletException {
//		try {
//			JobScheduler.main(null);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Startup class initialized successfully");
	}
}