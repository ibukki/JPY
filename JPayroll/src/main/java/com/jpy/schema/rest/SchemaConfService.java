package com.jpy.schema.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.jpy.common.dao.HibernateDaoFactory;
import com.jpy.schema.conf.dao.SchemaParamDao;
import com.jpy.schema.conf.eo.SchemaConfEO;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("schemaconf")
public class SchemaConfService {
	private static Logger logger = Logger.getLogger(SchemaConfService.class);
	
	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<String> getSchemaNameList(@Context ServletContext servletContext){
		
		SchemaParamDao confDao = (SchemaParamDao) HibernateDaoFactory
				.getDaoInstance(SchemaParamDao.class, servletContext);
		List<?> confList = confDao.findAll(SchemaConfEO.class);
		List<String> nameList = new ArrayList<String>();
		for (Iterator<?> iterator = confList.iterator(); iterator.hasNext();) {
			SchemaConfEO confEO = (SchemaConfEO) iterator.next();
			nameList.add(confEO.getSchemaId());
		}
		
		return nameList;
	}
}
