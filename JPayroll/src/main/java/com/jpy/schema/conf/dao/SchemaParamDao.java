package com.jpy.schema.conf.dao;

import javax.servlet.ServletContext;

import com.jpy.common.dao.BaseHibernateDao;

public class SchemaParamDao extends BaseHibernateDao {
	
	public SchemaParamDao(ServletContext servletContext){
		super(servletContext);
	}
	
}
