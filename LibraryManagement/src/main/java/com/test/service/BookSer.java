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
import com.test.model.UBorrow;
import com.test.repositry.BookRepositry;
@Service
@Transactional
public class BookSer {
	
	@Autowired
	private BookService bk;
	private UBorrowService ubs;
	private BookRepositry br;
	
	
	
	public BookSer(BookRepositry br) {
	
		this.br = br;
	}



//	public BookSer()
//	{
//		
//	}
	

	
	  public List<Book> sendonebook(String bookname) {
	  	  List<Book> result = bk.searchBook();
	  	 Configuration cfg = new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory fac = cfg.buildSessionFactory();
		  Session s = fac.openSession();
		
		  System.out.println("bName "+bookname);
		  
		  String hql = "from Book where bname='"+bookname+"'";
		  Query q=s.createQuery(hql);
		  List res = q.list();
		  s.close();
		  fac.close();
		  return res;
	    }
	 
	  
	  public List<Book> getAllBooks(){
		  List<Book> list =  (List<Book>)br.findAll();
		  return list;
		 }
		 
		 /*
		  * TODO: Get Book By keyword
		  */
		 public Book getByKeyword(String keyword){
		  return br.findByKeyword(keyword);
		 }
		
	
	


	public List<UBorrow> displaydetails()
	    {
	      List<UBorrow> r = bk.getDetails();
	  	  
	  	
	  	  
	  	 
	  	 
	  	  return r;
	    }
}
