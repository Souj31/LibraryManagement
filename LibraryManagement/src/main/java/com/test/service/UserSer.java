package com.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Book;
import com.test.model.UserR;
import com.test.repositry.UserRRepositry;

//import com.test.entities.UserR;

//import com.test.dao.UserRDao;

@Service
@Transactional
public class UserSer {
	
	private UserRRepositry urr;
	public static String loggeduser =null;
	
	
	
	
	public UserSer(UserRRepositry urr) {
		this.urr = urr;
	}


	@Autowired
    private UserService us;

//    public UserSer()
//    {
//    	
//    }

public boolean logintest(UserR user) {
	
		
		List<UserR> result1 = us.findallobjects();
		
		for (UserR ur : result1) {
        	if(ur.getUname().equals(user.getUname())) {
        		if(ur.getPassword().equals(user.getPassword())) {
        			
        			loggeduser = user.getUname();
        			System.out.println(loggeduser);
        			return true;
        			
        		}
        		return false;
        	}
        }
		
		return false;
	}

  public List<UserR> displayuser()
  {
	  Configuration cfg = new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory fac = cfg.buildSessionFactory();
	  Session s = fac.openSession();
	
	  System.out.println("p "+loggeduser);
	  
	  String hql = "from UserR where username='"+loggeduser+"'";
	  Query q=s.createQuery(hql);
	  List res = q.list();
	  s.close();
	  fac.close();
	  return res;
	  
	  
  }
  
  public UserR sendoneuser(UserR username) {
	  List<UserR> result = us.findallobjects();
	  for(UserR obj: result) {
		  if(obj.getUname().equals(username)) {
			  return obj;
		  }
	  }
	  
	  return null;
  }
  
  
  public UserR getByKeyword(String keyword){
	  return urr.findByKeyword(keyword);
	 }
  
}

