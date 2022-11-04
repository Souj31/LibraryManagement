package com.test.service;

import java.util.List;

import com.test.model.Book;
import com.test.model.UBorrow;



public interface BookService {
	
	List<Book> getAllBook();
	
	Book saveBook(Book book);
		
	Book getBookById(int id);
		
	Book updateBook(Book book);
		
	void deleteBookById(int id);
	
	List<Book> searchBook();	
	
	List<UBorrow> getDetails();
	

	
	
	

}
