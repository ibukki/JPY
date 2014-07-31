package com.jpy.schema.dao;

import javax.servlet.ServletContext;

import com.jpy.common.dao.BaseHibernateDao;

public class SchemaDao extends BaseHibernateDao{
	
	public SchemaDao(ServletContext servletContext){
		super(servletContext);
	}
}
