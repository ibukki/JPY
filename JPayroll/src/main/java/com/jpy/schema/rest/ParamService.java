package com.jpy.schema.rest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jpy.common.dao.HibernateDaoFactory;
import com.jpy.schema.conf.SchemaConfParser;
import com.jpy.schema.conf.bean.SchemaConfParamXMLBean;
import com.jpy.schema.conf.dao.SchemaParamDao;
import com.jpy.schema.conf.eo.SchemaConfEO;
import com.jpy.schema.conf.vo.SchemaConf;
import com.jpy.schema.conf.vo.SchemaConfParam;

@Component
@Path("params")
public class ParamService {
	
	private static Logger logger = Logger.getLogger(ParamService.class);
	
	@GET
	@Path("input")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SchemaConfParam> loadInputParams(@QueryParam("schemaId") String schemaId, @Context ServletContext servletContext){
		
		SchemaParamDao confDao = (SchemaParamDao) HibernateDaoFactory
				.getDaoInstance(SchemaParamDao.class, servletContext);
		SchemaConfEO schemaConf = (SchemaConfEO) confDao.findById(SchemaConfEO.class, schemaId);
		if(schemaConf != null){
			byte[] inputParamBytes = schemaConf.getInputParam();
			return SchemaConfParser.parseConfParams(inputParamBytes, "input");
		}else{
			logger.debug("no configuration loaded from database");
			return Collections.emptyList();
		}
		

	}
	
	@GET
	@Path("output")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SchemaConfParam> loadOutputParams(@QueryParam("schemaId") String schemaId, @Context ServletContext servletContext){
		SchemaParamDao confDao = (SchemaParamDao) HibernateDaoFactory
				.getDaoInstance(SchemaParamDao.class, servletContext);
		SchemaConfEO schemaConf = (SchemaConfEO) confDao.findById(SchemaConfEO.class, schemaId);
		if(schemaConf != null){
			byte[] outputParamBytes = schemaConf.getOutputParam();
			return SchemaConfParser.parseConfParams(outputParamBytes, "output");
		}else{
			logger.debug("no configuration loaded from database");
			return Collections.emptyList();
		}
		
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int saveParams(@QueryParam("schemaId") String schemaId,SchemaConf schemaConfVO,
			@Context ServletContext servletContext,
			@Context HttpServletRequest request) {
		List<SchemaConfParamXMLBean> inputXMLConfBeanList = this.convertVO2XMLBean(schemaConfVO.getInput());
		String inputXML = SchemaConfParser.convertConfBeanToXML(inputXMLConfBeanList, "input");
		
		List<SchemaConfParamXMLBean> outputXMLConfBeanList = this.convertVO2XMLBean(schemaConfVO.getOutput());
		String outputXML = SchemaConfParser.convertConfBeanToXML(outputXMLConfBeanList, "output");
		SchemaConfEO schemaConf = new SchemaConfEO();
		schemaConf.setSchemaId(schemaId);
		try {
			schemaConf.setInputParam(inputXML.getBytes("UTF-8"));
			schemaConf.setOutputParam(outputXML.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.debug("encoding failed");
		}
		SchemaParamDao confDao = (SchemaParamDao) HibernateDaoFactory
				.getDaoInstance(SchemaParamDao.class, servletContext);
		return confDao.saveorUpdate(schemaConf);
	}
	
	
	private List<SchemaConfParamXMLBean> convertVO2XMLBean(List<SchemaConfParam> paramList){
		List<SchemaConfParamXMLBean> confXMLBeanList = new ArrayList<SchemaConfParamXMLBean>();
		for (SchemaConfParam confParam : paramList) {
			SchemaConfParamXMLBean confXMLBean = new SchemaConfParamXMLBean();
			try {
				BeanUtils.copyProperties(confXMLBean, confParam);
			} catch (Exception e) {
				logger.debug("failed to copy properties");
			}
			confXMLBeanList.add(confXMLBean);
		}
		return confXMLBeanList;
	}
}
