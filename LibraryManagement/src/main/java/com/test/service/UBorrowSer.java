package com.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Book;
import com.test.model.UBorrow;


@Service
@Transactional
public class UBorrowSer {

	@Autowired
    private UBorrowService bk;

    public UBorrowSer()
    {
    	
    }
    
    
    
    
    public void insertbook(UBorrow ub, int id) {
    	Book b = bk.getBookById(id);
    	 Configuration cfg = new Configuration();
   	  cfg.configure("hibernate.cfg.xml");
   	  SessionFactory fac = cfg.buildSessionFactory();
   	  Session s = fac.openSession();
   	  Transaction tx = s.beginTransaction();
   	
   	  s.save(ub);
   	  tx.commit();
		
   	s.close();
	  fac.close();
    }
    
    public List<UBorrow> displaydetails()
    {
      List<UBorrow> r = bk.getDetails();
  	  Configuration cfg = new Configuration();
  	  cfg.configure("hibernate.cfg.xml");
  	  SessionFactory fac = cfg.buildSessionFactory();
  	  Session s = fac.openSession();
  	
  	  System.out.println("d "+UserSer.loggeduser);
  	  
  	 // String hql = "from UBorrow where uname='"+UserSer.loggeduser+"'";
  	  //Query q=s.createQuery(hql);
  	  //List res = q.list();
  	  s.close();
  	  fac.close();
  	  return r;
    }
}

