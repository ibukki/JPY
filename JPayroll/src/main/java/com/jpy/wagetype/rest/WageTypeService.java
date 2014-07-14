package com.jpy.wagetype.rest;

import java.text.ParseException;
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import com.jpy.common.dao.HibernateDaoFactory;
import com.jpy.wagetype.dao.WageTypeDao;
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
	public List<WageTypeVO> getWageTypeList(
			@Context ServletContext servletContext) {
		List<WageTypeVO> wageTypeList = new ArrayList<WageTypeVO>();

		WageTypeDao wageTypeDao = (WageTypeDao) HibernateDaoFactory
				.getDaoInstance(WageTypeDao.class, servletContext);
		if (wageTypeDao != null) {
			List<WageTypeEO> wageListEO = wageTypeDao.findAll(WageTypeEO.class);
			if (wageListEO != null) {
				for (WageTypeEO wageTypeEO : wageListEO) {
					WageTypeVO wagetypeVO = new WageTypeVO();
					this.ConvertWageTypeBeanFromDB2UI(wagetypeVO, wageTypeEO);
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
	public List<WageTypeVO> saveWageType(List<WageTypeVO> wageTypeList,
			@Context ServletContext servletContext,
			@Context HttpServletRequest request) {
		List<WageTypeEO> wageTypeListToSave = new ArrayList<WageTypeEO>();
		List<WageTypeEO> wageTypeListSaved = new ArrayList<WageTypeEO>();
		List<WageTypeVO> wageTypeSucceed = new ArrayList<WageTypeVO>();

		for (WageTypeVO wageTypeVO : wageTypeList) {
			WageTypeEO wageTypeEO = new WageTypeEO();
			this.ConvertWageTypeBeanFromUI2DB(wageTypeEO, wageTypeVO);
			wageTypeListToSave.add(wageTypeEO);
		}

		WageTypeDao wageTypeDao = (WageTypeDao) HibernateDaoFactory
				.getDaoInstance(WageTypeDao.class, servletContext);
		if (wageTypeDao != null) {
			wageTypeListSaved = wageTypeDao.saveAll(wageTypeListToSave);
			for (WageTypeEO savedEO : wageTypeListSaved) {
				WageTypeVO savedVO = new WageTypeVO();
				this.ConvertWageTypeBeanFromDB2UI(savedVO, savedEO);
				wageTypeSucceed.add(savedVO);
			}
		}
		return wageTypeSucceed;
	}

	private void ConvertWageTypeBeanFromDB2UI( WageTypeVO vo, WageTypeEO eo) {
		try {
			BeanUtils.copyProperties(vo, eo);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			if (null != eo.getBegda()) {
				vo.setBegdaString(sdf.format(eo.getBegda()));
			}
			if (eo.getEndda() != null) {
				vo.setEnddaString(sdf.format(eo.getEndda()));
			}
		} catch (Exception e) {
			logger.error("error convert data");
		}

	}

	private void ConvertWageTypeBeanFromUI2DB(WageTypeEO eo,WageTypeVO vo) {
		try {
			BeanUtils.copyProperties(eo, vo);
			try {
				eo.setBegda(DateUtils.parseDateStrictly(vo.getBegdaString(),
						"yyyyMMdd"));
				eo.setEndda(DateUtils.parseDateStrictly(vo.getEnddaString(),
						"yyyyMMdd"));
			} catch (ParseException e) {
				logger.error("Parse date failed", e);
			}
		} catch (Exception e) {
			logger.error("error convert data");
		}
	}
}
