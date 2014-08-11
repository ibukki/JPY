package com.jpy.masterdata.util;


import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import com.jpy.common.util.HibernateUtil;
import com.jpy.masterdata.eo.EmployeeEO;

public class HibernateUtilTest {
//	@Test  
//    public void testGetSession() {  
//        Session session = HibernateUtil.getSessionFactory().openSession();  
//          
//        Assert.assertNotNull(session);  
//          
//        HibernateUtil.getSessionFactory().close();  
//    }
	
//	@Test  
//    public void testSave() throws ParseException {  
//        EmployeeEO employee = new EmployeeEO();
//        employee.setFirstName("Ryan");
//        employee.setLastName("Huang");
//        employee.setGender("1");
//        employee.setDepartment("HCM");
//        employee.setJob("Developer");
//        employee.setDateOfBirth(DateUtils.parseDate("1987-12-14", "yyyy-MM-dd"));
//          
//        Session session = HibernateUtil.getSession();  
//        Transaction tx = session.beginTransaction();  
//          
//        session.save(employee);  
//          
//        tx.commit();  
//        HibernateUtil.closeSession();  
//    }  
}
