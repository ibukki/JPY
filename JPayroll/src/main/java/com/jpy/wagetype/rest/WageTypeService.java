package com.jpy.wagetype.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jpy.wagetype.eo.WageTypeEO;
import com.jpy.wagetype.vo.WageTypeVO;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("wagetypes")
public class WageTypeService {
	
	private static Logger logger = Logger.getLogger(WageTypeService.class);
	
	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<WageTypeVO> getWageTypeList(@Context ServletContext servletContext){
		List<WageTypeVO> wageTypeList = new ArrayList<WageTypeVO>();
		
		SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("SessionFactory");
		if(sessionFactory != null){
			Session session = sessionFactory.openSession();
			Object result = session.createQuery("from WageTypeEO").list();
			if(result != null){
				List<WageTypeEO> wageListEO = (List<WageTypeEO>) result;
				for (WageTypeEO wageTypeEO : wageListEO) {
					WageTypeVO wagetypeVO = new WageTypeVO();
					wagetypeVO.setWageTypeId(wageTypeEO.getWageTypeId());
					wagetypeVO.setSequence(wageTypeEO.getSequence());
					wagetypeVO.setAmount(wageTypeEO.getAmount());
					wagetypeVO.setCount(wageTypeEO.getCount());
					wagetypeVO.setCurrency(wageTypeEO.getCurrency());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(!"".equals(wageTypeEO.getBegda())){
						wagetypeVO.setBegdaString(sdf.format(wageTypeEO.getBegda()));
					}
					if(!"".equals(wageTypeEO.getEndda())){
						wagetypeVO.setEnddaString(sdf.format(wageTypeEO.getEndda()));
					}
					wageTypeList.add(wagetypeVO);
				}
			}
		}
		return wageTypeList;
	}
	
	@POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public List<WageTypeVO> saveWageType(List<WageTypeVO> wageTypeList, @Context ServletContext servletContext, @Context HttpServletRequest request){
		
		for (WageTypeVO wageTypeVO : wageTypeList) {
			String begda = wageTypeVO.getBegdaString();
		}
		
		return wageTypeList;
	}
}
