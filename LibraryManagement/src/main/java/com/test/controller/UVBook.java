package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.test.model.Admin;
import com.test.model.Book;
import com.test.model.UBorrow;
import com.test.repositry.UBorrowRepositry;
import com.test.service.BookSer;
import com.test.service.BookService;
import com.test.service.UBorrowSer;
import com.test.service.UBorrowService;
import com.test.service.UserSer;


@Controller
public class UVBook {

	private UBorrowRepositry borrowrepo;
	private BookService bookService;
	private BookSer bs1;

	private UBorrowService borrowService;
	private UBorrowSer bb2;





	public UVBook(UBorrowRepositry borrowrepo, BookService bookService, BookSer bs1, UBorrowService borrowService,
			UBorrowSer bb2) {
		super();
		this.borrowrepo = borrowrepo;
		this.bookService = bookService;
		this.bs1 = bs1;
		this.borrowService = borrowService;
		this.bb2 = bb2;
	}


	@RequestMapping("/search")
	public String homePage()
	{
		return "search";
	}


	// handler method to handle list students and return mode and view
	@GetMapping("/viewbook")
	public String listBook(Model model) {
		model.addAttribute("book", bookService.getAllBook());
		return "viewbook";
	}


	@GetMapping("/viewbook/{id}" )
	public String bBook(@PathVariable int id,
			@ModelAttribute("book") Book book,
			Model model,String keyword,HttpSession session) {


		Date date = new Date();
		SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = fr.format(date);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 7);
		String rRate = fr.format(c.getTime());

		UBorrow ub = new UBorrow();
		Book bok = bookService.getBookById(id);


		int copies=Integer.parseInt(bok.getBcopies());	
		if(copies>0) {
			List<String> same = borrowrepo.samebookborrow(UserSer.loggeduser);
			if(!same.contains(bok.getBname())) {
			//ub.setId(id);
			System.out.println("bID - "+bookService.getBookById(id).getBname());
			ub.setuName(UserSer.loggeduser);
			System.out.println("User name - "+UserSer.loggeduser);
			System.out.println("Auth - "+bok.getBauthor());
			ub.setBauthor(bok.getBauthor());
			ub.setPdate(bok.getPdate());
			ub.setBname(bok.getBname());
			ub.setBpublisher(bok.getBpublisher());
			ub.setBdate(currDate);
			ub.setRdate(rRate);
			ub.setStatus("Borrowed");

			//bb2.insertbook(ub, id);
			// save updated student object
			borrowService.borrowBook(ub);

			int originalcount = Integer.parseInt(bookService.getBookById(id).getBcopies());
			int remcount = originalcount - 1;
			String rcount = String.valueOf(remcount);


			bok.setBcopies(rcount);
			bookService.updateBook(bok);
			session.setAttribute("br",(bok.getBname()+" Borrowed Successfully"));
			}
			else
			{
				session.setAttribute("same", "The Book "+bok.getBname()+" Already Borrowed");
			}
		}
		else {
			session.setAttribute("var",("You Cannot Borrow "+bok.getBname()+" as the Copies are Zero"));
		}


		return "redirect:/viewbook";		
	}

	@GetMapping("/ub")
	public String Bookdetails(Model model,UBorrow uB) {
		model.addAttribute("uborrow", borrowService.getDetails());
		//List<UBorrow> s = bb2.displaydetails();
		//System.out.println("listyt :"+s);
		return "ub";
	}


	@GetMapping(path = {"/vbooksubmit"})
	public String home(Book bk, Model model, String keyword,HttpSession session) {
		System.out.println("keyword " + keyword);
		String ser = "";
		if(keyword==null || keyword.equals("")) {
			model.addAttribute("book", bookService.getAllBook());
			ser="viewbook";
		}else {
			Book list = bs1.getByKeyword(keyword);
			System.out.println("All Books : "+list);
			if(list == null)
			{
				model.addAttribute("book", bookService.getAllBook());
				session.setAttribute("msg", (keyword+" - Book Not Found"));
				ser = "viewbook";
			}
			else
			{
				model.addAttribute("book", list);
				ser="search";
			}
		}
		return ser;	

	}

	@GetMapping("/vbooksubmit/{id}")
	public String searchbBook(@PathVariable int id,
			@ModelAttribute("book") Book book,
			Model model,HttpSession session) {


		Date date = new Date();
		SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = fr.format(date);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 7);
		String rRate = fr.format(c.getTime());

		UBorrow ub = new UBorrow();
		Book bok = bookService.getBookById(id);
		//ub.setId(id);
		int copies=Integer.parseInt(bok.getBcopies());
		if(copies>0) {
			List<String> same = borrowrepo.samebookborrow(UserSer.loggeduser);
			if(!same.contains(bok.getBname())) {
			System.out.println("bID - "+bookService.getBookById(id).getBname());
			ub.setuName(UserSer.loggeduser);
			System.out.println("User name - "+UserSer.loggeduser);
			System.out.println("Auth - "+bok.getBauthor());
			ub.setBauthor(bok.getBauthor());
			ub.setPdate(bok.getPdate());
			ub.setBname(bok.getBname());
			ub.setBpublisher(bok.getBpublisher());
			ub.setBdate(currDate);
			ub.setRdate(rRate);
			ub.setStatus("Borrowed");
			//bb2.insertbook(ub, id);
			// save updated student object
			borrowService.borrowBook(ub);

			int originalcount = Integer.parseInt(bookService.getBookById(id).getBcopies());
			int remcount = originalcount - 1;
			String rcount = String.valueOf(remcount);


			bok.setBcopies(rcount);
			bookService.updateBook(bok);
			session.setAttribute("br", bok.getBname()+" Borrowed Successfully");
			}
			else
			{
				session.setAttribute("same", "The Book "+bok.getBname()+" Already Borrowed");
			}
		}
		else {
			session.setAttribute("var",("You Cannot Borrow "+bok.getBname()+" as the Copies are Zero"));
		}

		return "redirect:/search";		
	}



}