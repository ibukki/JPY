package com.jpy.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.jpy.common.util.HibernateUtil;

public class BaseHibernateDao {
	
	/**
	 * hibernate session
	 */
	private Session session;
	
	public BaseHibernateDao(){
		this.session = this.getSession();
	}
	
	public BaseHibernateDao(ServletContext servletContext){
		this.session = this.getSession(servletContext);
	}
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public int save(Object object) {
		int res = -1;
		Transaction ts = session.beginTransaction();
		try {
			session.save(object);
			ts.commit();
			res = 1;
		} catch (HibernateException e) {
			ts.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	/**
	 * 
	 * @param cls
	 * @param id
	 * @return
	 */
	public Object findById(Class cls, Serializable id) {
		Object obj = null;
		obj = session.get(cls, id);
		session.close();
		return obj;
	}
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public int udpate(Object object) {
		int res = -1;
		Transaction ts = session.beginTransaction();
		try {
			session.update(object);
			ts.commit();
			res = 1;
		} catch (HibernateException e) {
			ts.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	/**
	 * 
	 * @param cls
	 * @param id
	 * @return
	 */
	public int delete(Class cls, Serializable id) {
		int res = -1;
		Transaction ts = session.beginTransaction();
		Object object = findById(cls, id);
		try {
			session.delete(object);
			ts.commit();
			res = 1;
		} catch (HibernateException e) {
			ts.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	/**
	 * 
	 * @param cls
	 * @return
	 */
	public List findAll(Class cls) {
		List list = new ArrayList();
		list = session.createCriteria(cls).list();
		return list;
	}
	
	/**
	 * 
	 * @param cls
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List findAll(Class cls, int pageNo, int pageSize) {
		List list = new ArrayList();
		list = session.createCriteria(cls)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();

		return list;
	}
	
	/**
	 * 
	 * @param cls
	 * @param obj
	 * @return
	 */
	public List findByObject(Class cls, Object obj) {
		List list = new ArrayList();
		list = session.createCriteria(cls).add(Example.create(obj)).list();
		return list;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	/**
	 * 
	 * @return
	 */
	private Session getSession(ServletContext servletContext) {
		SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("SessionFactory");
		if(sessionFactory != null){
			return sessionFactory.openSession();
		}else{
			return this.getSession();
		}
	}
}