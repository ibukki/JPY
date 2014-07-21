package com.jpy.schema.rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.jpy.common.dao.HibernateDaoFactory;
import com.jpy.schema.conf.dao.SchemaParamDao;
import com.jpy.schema.conf.eo.SchemaConfEO;
import com.jpy.schema.conf.vo.Parameter;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("params")
public class ParamService {
	
	private static Logger logger = Logger.getLogger(ParamService.class);
	
	@GET
	@Path("input")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameter> loadInputParams(@QueryParam("schemaId") String schemaId, @Context ServletContext servletContext){
		
		SchemaParamDao confDao = (SchemaParamDao) HibernateDaoFactory
				.getDaoInstance(SchemaParamDao.class, servletContext);
		SchemaConfEO schemaConf = (SchemaConfEO) confDao.findById(SchemaConfEO.class, schemaId);
		byte[] inputParamBytes = schemaConf.getInputParam();
		
		return null;

	}
	
	@GET
	@Path("output")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameter> loadOutputParams(@QueryParam("schemaId") String schemaId, @Context ServletContext servletContext){
		return null;
	}
}
