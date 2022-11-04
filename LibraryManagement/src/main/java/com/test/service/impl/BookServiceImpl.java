package com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.model.Book;
import com.test.model.UBorrow;
import com.test.repositry.BookRepositry;
import com.test.repositry.UBorrowRepositry;
import com.test.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	
	private BookRepositry bookRepository;
	
	private UBorrowRepositry ubr;
	
	

	public BookServiceImpl(BookRepositry bookRepository,UBorrowRepositry ubr) {
		this.bookRepository = bookRepository;
		this.ubr=ubr;
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
		
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public List<Book> searchBook() {
		return bookRepository.findAll();
	}

	@Override
	public List<UBorrow> getDetails() {
		List<UBorrow> res = ubr.findAll(); 
		return res;
	}
	


}
