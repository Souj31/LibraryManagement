package com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.Book;
import com.test.model.UBorrow;
import com.test.repositry.BookRepositry;
import com.test.repositry.UBorrowRepositry;
import com.test.repositry.UserRRepositry;
import com.test.service.UBorrowService;
import com.test.service.UserSer;

@Repository
public class UBorrowImpl implements UBorrowService{
	

	private UBorrowRepositry ubr;
	private BookRepositry br;
	private UserRRepositry ur;
	
	public UBorrowImpl(UBorrowRepositry ubr,BookRepositry br,UserRRepositry ur) {
		this.ubr = ubr;
		this.br=br;
		this.ur=ur;
	}

	@Override
	public List<UBorrow> getAllUser() {
		return ubr.findAll();
		
	}

	@Override
	public UBorrow saveUser(UBorrow ub) {
		return ubr.save(ub);
	}

	@Override
	public UBorrow getUserById(int id) {
		return ubr.findById(id).get();
	}

	@Override
	public UBorrow updateUser(UBorrow ub) {
		return ubr.save(ub);
	}

	@Override
	public void deleteUserById(int id) {
		ubr.deleteById(id);
		
	}

	@Override
	public Book getBookById(int id) {
		
		return br.findById(id).get();
	}

	@Override
	public UBorrow borrowBook(UBorrow ub) {
		
		return ubr.save(ub);
	}

	@Override
	public List<UBorrow> getDetails() {
		
		return ubr.userborrow(UserSer.loggeduser);
		}

	@Override
	public List<UBorrow> AdminAllUserDetails() {
	       return ubr.findAll();
	}

	@Override
	public void returnById(int id) {
		ubr.deleteById(id);
	}
	
}
