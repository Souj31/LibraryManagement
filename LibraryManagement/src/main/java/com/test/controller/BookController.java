package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.exceptions.ResourceNotFoundException;
import com.test.model.Book;
import com.test.model.UBorrow;
import com.test.model.UserR;
import com.test.repositry.BookRepositry;
import com.test.service.BookSer;
import com.test.service.BookService;
import com.test.service.UBorrowService;

@Controller
public class BookController {
	
	private BookRepositry br;
	private BookService bookService;
	
	private UBorrowService borrowService;
	
	private BookSer bs;

	public BookController(BookService bookService,UBorrowService borrowService,BookSer bs,BookRepositry br) {
		this.bookService = bookService;
		this.borrowService=borrowService;
		this.bs=bs;
		this.br=br;
	}
	
	// handler method to handle list students and return mode and view
		@GetMapping("/book")
		public String listBook(Model model) {
			model.addAttribute("book", bookService.getAllBook());
			return "book";
		}
		
		@GetMapping("/book/new")
		public String createBookForm(Model model) {
			
			// create student object to hold student form data
			Book bk = new Book();
			model.addAttribute("bk", bk);
			return "create_bk";
			
		}
		
		@PostMapping("/book")
		public String saveBook(@ModelAttribute("bk") Book bk,HttpSession session) {
			bookService.saveBook(bk);
			session.setAttribute("ad", "Book Added Successfully");
			return "redirect:/book";
		}
		
		@GetMapping("/book/edit/{id}")
		public String editBookForm(@PathVariable int id, Model model) {
			model.addAttribute("bk", bookService.getBookById(id));
			return "edit_bk";
		}

		@PostMapping("/book/{id}")
		public String updateBook(@PathVariable int id,
				@ModelAttribute("bk") Book bk,
				Model model) {
			
			// get student from database by id
			Book existingBook = bookService.getBookById(id);
			existingBook.setId(id);
			existingBook.setBname(bk.getBname());
			existingBook.setBauthor(bk.getBauthor());
			existingBook.setBpublisher(bk.getBpublisher());
			existingBook.setPdate(bk.getPdate());
			existingBook.setBcopies(bk.getBcopies());
			// save updated student object
			bookService.updateBook(existingBook);
			return "redirect:/book";		
		}
		
		// handler method to handle delete student request
		
		@GetMapping("/book/{id}")
		public String deleteBook(@PathVariable int id) {
			bookService.deleteBookById(id);
			return "redirect:/book";
		}
		
		@GetMapping("/userborrowed")
		public String Bookdetails(Model model) {
			model.addAttribute("uborrow", borrowService.AdminAllUserDetails());
			//List<UBorrow> s = bs.displaydetails();
			//System.out.println("listyt :"+s);
			return "userborrowed";
		}
		
		@GetMapping("/userborrowed/{id}")
		public String returnbBook(@PathVariable int id,
				@ModelAttribute("uborrow") UBorrow ub,
				Model model,HttpSession session)
		{
			
			 
			 UBorrow u = borrowService.getUserById(id);
			 //u.setStatus("Returned");
			 //borrowService.updateUser(u);
			 String bn = u.getBname();
			 borrowService.returnById(id);
			 System.out.println("bn : "+bn);
			 //System.out.println("ID : "+id);
			 Book bk1 = br.ReturnedBook(bn);
			 System.out.println("Book : "+ bk1);
			 
			 int oc = Integer.parseInt(bk1.getBcopies());
			 System.out.println("oc : " + oc);
			 String uc = String.valueOf(oc +1);
			 bk1.setBcopies(uc);
			 bookService.updateBook(bk1);
			
			 
			
			      return "redirect:/userborrowed";
		}
		
	
		//postman exception handling//
		@GetMapping("/Book/{id}")
		public ResponseEntity<Book> getBookById(@PathVariable(value = "id") int BookId)
				throws ResourceNotFoundException {
			Book employee = br.findById(BookId)
					.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + BookId));
			return ResponseEntity.ok().body(employee);
		}
}
