package com.jpy.common.util;

import org.apache.log4j.Logger;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;  

public class HibernateUtil {  
    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);  
   
      
    private HibernateUtil() {  
          
    }  
    
    public static SessionFactory getSessionFactory(){
    	SessionFactory sessionFactory = null;
    	try {  
            LOGGER.debug("HibernateUti.static - loading cofig");  
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")  
                    .buildSessionFactory();  
            LOGGER.debug("HibernateUtil.static - end");  
        } catch (Throwable ex) {  
            ex.printStackTrace();  
            LOGGER.error("HibernateUti error : ExceptionInInitializerError");  
            throw new ExceptionInInitializerError(ex);  
        }
    	return sessionFactory;
    }
     
    
    public static SessionFactory getSessionFactory(String configUrl){
    	SessionFactory sessionFactory = null;
    	try {  
            LOGGER.debug("HibernateUti.static - loading cofig");  
            sessionFactory = new Configuration().configure(configUrl)  
                    .buildSessionFactory();  
            LOGGER.debug("HibernateUtil.static - end");  
        } catch (Throwable ex) {  
            ex.printStackTrace();  
            LOGGER.error("HibernateUti error : ExceptionInInitializerError");  
            throw new ExceptionInInitializerError(ex);  
        }
    	return sessionFactory;
    }
}  