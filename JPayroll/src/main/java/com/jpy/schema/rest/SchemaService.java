package com.jpy.schema.rest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.jpy.common.dao.HibernateDaoFactory;
import com.jpy.schema.dao.SchemaDao;
import com.jpy.schema.eo.SchemaEO;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("schema")
public class SchemaService {
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int saveParams(SchemaEO schemaEO,
			@Context ServletContext servletContext,
			@Context HttpServletRequest request) {
		
		SchemaDao schemaDao = (SchemaDao) HibernateDaoFactory
				.getDaoInstance(SchemaDao.class, servletContext);
		
		int rCode = schemaDao.saveorUpdate(schemaEO);
		return rCode;
	}
}
