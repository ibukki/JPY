package com.jpy.masterdata.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.jpy.masterdata.eo.EmployeeEO;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("employees")
public class EmployeeService {
	
	private static Logger logger = Logger.getLogger(EmployeeService.class);
	
	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<EmployeeEO> getAllEmployees() {
		List<EmployeeEO> employees = new ArrayList<EmployeeEO>();
		
		
		
		return employees;
	}
	
	
}
