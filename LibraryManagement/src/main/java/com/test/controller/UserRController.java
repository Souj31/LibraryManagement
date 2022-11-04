package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.exceptions.ResourceNotFoundException;
import com.test.model.Book;
import com.test.model.UserR;
import com.test.repositry.UserRRepositry;
import com.test.service.UserSer;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

@Controller
public class UserRController {


    private UserRRepositry usrepo;
	private UserService userService;

	private UserSer ser;

	

	public UserRController(UserRRepositry usrepo, UserService userService, UserSer ser) {
		super();
		this.usrepo = usrepo;
		this.userService = userService;
		this.ser = ser;
	}

	@RequestMapping("/index")
	public String homePage()
	{
		return "index";
	}
	
	@RequestMapping("/udashboard")
	public String udashboard()
	{
		return "udashboard";
	}


	@RequestMapping("/userlogin")
	public String loginPage(Model model,UserR user)
	{
		model.addAttribute("user",user);
		return "login";
	}

	//	
	@RequestMapping(value="/usersubmit", method=RequestMethod.POST)
	public String loginSubmit(@Valid @ModelAttribute("user") UserR usr, BindingResult bindingResult,HttpServletResponse res,HttpSession session) throws IOException
	{
		PrintWriter out = res.getWriter();
		if(bindingResult.hasErrors())
		{

			System.out.println("error");
			return "login";

		}
		else {
			boolean x = ser.logintest(usr);
			System.out.println(x);
			if(x) {
				return "udashboard";
			}
			else {
			    //out.println("<center ><h3 style='color:red; align:bottom;'>Invalid Credentials</h3></center>");
			    session.setAttribute("msg", "Invalid Credentials");
				return "login";
			}
		}
	}
	// handler method to handle list students and return mode and view
			@GetMapping("/auserview")
			public String listBook(Model model) {
				model.addAttribute("book", userService.getAllUser());
				return "auserview";
			}

	// handler method to handle list students and return mode and view
	@GetMapping("/uprofile")
	public String listUser(Model model, UserR username) {
		model.addAttribute("userr", ser.displayuser());

		List<UserR> s = ser.displayuser();
		//List<UserR> s = ser.displayuser(username);
		System.out.println(s);


		return "uprofile";
	}

	@GetMapping("/userr")
	public String createUserForm(Model model,HttpSession session) {

		// create student object to hold student form data
		UserR user = new UserR();
		model.addAttribute("user", user);
		return "create_user";

	}

	@PostMapping("/userr")
	public String saveUser(@ModelAttribute("user") UserR user,HttpSession session) {
		List<String> usr = usrepo.AllUserNaes();
		String page = "";
		if(usr.contains(user.getUname()))
		{
			session.setAttribute("msg", "Username Already Exists.");
			page = "create_user";
		}
		else
		{
			userService.saveUser(user);
			session.setAttribute("msg", "New Account Has Been Created");
			
			page = "redirect:/userr";
		}
		
		return page;
	}

	@GetMapping("/uprofile/edit/{id}")
	public String editUserForm(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	@PostMapping("/uprofile/{id}")
	public String updateUser(@PathVariable int id,
			@ModelAttribute("user") UserR user,
			Model model,HttpSession session) {

		// get student from database by id
		UserR existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFname(user.getFname());
		existingUser.setLname(user.getLname());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhoneno(user.getPhoneno());
		existingUser.setUname(user.getUname());

		// save updated student object
		userService.updateUser(existingUser);
		session.setAttribute("msg", "Your Profile Has Been Updated");
		return "redirect:/uprofile";		
	}

	// handler method to handle delete student request

	@GetMapping("/uprofile/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
		return "redirect:/home";
	}


	@GetMapping(path = {"/uvsubmit"})
	public String home(UserR bk, Model model, String keyword,HttpSession session) {
		System.out.println("keyword " + keyword);
		String serc = "";
		if(keyword==null || keyword.equals("")) {
			model.addAttribute("book", userService.getAllUser());
			serc="auserview";
		}else {
			UserR list = ser.getByKeyword(keyword);
			System.out.println("All Books : "+list);
			if(list == null)
			{
				model.addAttribute("book", userService.getAllUser());
				session.setAttribute("msg", (keyword+" - User Not Found"));
				serc = "auserview";
			}
			else
			{
				model.addAttribute("book", list);
				serc="usearch";
			}
		}
		return serc;	

	}
	
	
	
	
	
	
	
	

	@GetMapping("/user/{id}")
	public ResponseEntity<UserR> getEmployeeById(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		UserR employee = usrepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}



}


