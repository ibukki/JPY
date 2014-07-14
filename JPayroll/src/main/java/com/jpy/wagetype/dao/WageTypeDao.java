package com.jpy.wagetype.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.jpy.common.dao.BaseHibernateDao;
import com.jpy.wagetype.eo.WageTypeEO;

public class WageTypeDao extends BaseHibernateDao{
	
	public WageTypeDao(ServletContext servletContext){
		super(servletContext);
	}
	
	public List<WageTypeEO> saveAll(List<WageTypeEO> wageList){
		List<WageTypeEO> resultList = new ArrayList<WageTypeEO>();
		for (WageTypeEO wageTypeEO : wageList) {
			int rs = this.saveorUpdate(wageTypeEO);
			if(rs > 0){
				resultList.add(wageTypeEO);
			}
		}
		return resultList;
	}
}
