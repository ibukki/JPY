package com.jpy.common.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

public class HibernateDaoFactory {

	private static Map<String, Object> daoBufferMap = null;

	private static Logger logger = Logger.getLogger(HibernateDaoFactory.class);
	
	/**
	 * 
	 * @param daoClaz
	 * @return
	 */
	public static Object getDaoInstance(Class<?> daoClaz) {
		Object dao = null;
		if (daoBufferMap != null) {
			dao = daoBufferMap.get(daoClaz.getName());
			if (dao == null) {
				try {
					dao = daoClaz.newInstance();
					daoBufferMap.put(daoClaz.getName(), dao);
				} catch (Exception e) {
					logger.error("failed to initize the dao class" + daoClaz, e);
				}
			}
		} else {
			daoBufferMap = new HashMap<String, Object>();
			try {
				dao = daoClaz.newInstance();
				daoBufferMap.put(daoClaz.getName(), dao);
			} catch (Exception e) {
				logger.error("failed to initize the dao class" + daoClaz, e);
			}
		}
		return dao;
	}
	
	/**
	 * 
	 * @param daoClaz
	 * @param servletContext
	 * @return
	 */
	public static Object getDaoInstance(Class<?> daoClaz,
			ServletContext servletContext) {
		Object dao = null;
		if (daoBufferMap != null) {
			dao = daoBufferMap.get(daoClaz.getName());
			if (dao == null) {
				try {
					dao = daoClaz.getDeclaredConstructor(ServletContext.class).newInstance(servletContext);
					daoBufferMap.put(daoClaz.getName(), dao);
				}catch(NoSuchMethodException e){
					logger.error("constructor with servlet context is not specified" + daoClaz, e);
				}catch (Exception e) {
					logger.error("failed to initize the dao class" + daoClaz, e);
				}
			}
		} else {
			daoBufferMap = new HashMap<String, Object>();
			try {
				dao = daoClaz.getConstructor(ServletContext.class).newInstance(servletContext);
				daoBufferMap.put(daoClaz.getName(), dao);
			}catch(NoSuchMethodException e){
				logger.error("constructor with servlet context is not specified" + daoClaz, e);
			}catch (Exception e) {
				logger.error("failed to initize the dao class" + daoClaz, e);
			}
		}
		return dao;
	}
}
