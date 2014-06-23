package com.jpy.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.jpy.common.util.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class HibernateListener
 *
 */
public class HibernateListener implements ServletContextListener {
	
	public final Logger logger = Logger.getLogger(HibernateListener.class);
	
    /**
     * Default constructor. 
     */
    public HibernateListener() {
        
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        SessionFactory sessionFactory = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
        if(sessionFactory != null && !sessionFactory.isClosed()){
            logger.info("Closing sessionFactory");
            sessionFactory.close();
        }
        logger.info("Released Hibernate sessionFactory resource");
    }
 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        logger.info("SessionFactory created successfully");
         
        servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
        logger.info("Hibernate SessionFactory Configured successfully");
    }
	
}
