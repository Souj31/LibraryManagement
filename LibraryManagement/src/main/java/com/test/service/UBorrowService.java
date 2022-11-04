package com.test.service;

import java.util.List;

import com.test.model.Book;
import com.test.model.UBorrow;



public interface UBorrowService {

	List<UBorrow> getAllUser();
	
	UBorrow saveUser(UBorrow user);
		
	UBorrow getUserById(int id);
		
	UBorrow updateUser(UBorrow user);
		
	void deleteUserById(int id);
	
	
	Book getBookById(int id);
	
	UBorrow borrowBook(UBorrow ub);
	
	List<UBorrow> getDetails();
	
	List<UBorrow> AdminAllUserDetails();
	
	void returnById(int id);
}