package com.jpy.masterdata.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jpy.masterdata.eo.EmployeeEO;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("employees")
public class EmployeeService {
	
	private static Logger logger = Logger.getLogger(EmployeeService.class);
	

	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<EmployeeEO> getAllEmployees(@Context ServletContext servletContext) {
		List<EmployeeEO> employees = new ArrayList<EmployeeEO>();
		
		SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("SessionFactory");
		if(sessionFactory != null){
			Session session = sessionFactory.openSession();
			Object result = session.createQuery("from EmployeeEO").list();
			if(result != null){
				return (List<EmployeeEO>) result;
			}
		}
		
		return employees;
	}
	
	
}
