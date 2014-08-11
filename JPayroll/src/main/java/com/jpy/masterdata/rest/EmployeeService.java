package com.jpy.masterdata.rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jpy.masterdata.eo.EmployeeEO;

@Component
@Path("employees")
public class EmployeeService {
	
	private static Logger logger = Logger.getLogger(EmployeeService.class);
	

	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<EmployeeEO> getAllEmployees(@Context ServletContext servletContext) {
		return null;
	}
	
	
}
