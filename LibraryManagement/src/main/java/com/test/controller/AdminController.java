package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Admin;

import com.test.service.AdminSer;
import com.test.service.AdminService;

@Controller
public class AdminController {
	
	private AdminService adminService;
	private AdminSer aser;

	public AdminController(AdminService adminService,AdminSer aser) {
		
		this.adminService = adminService;
		this.aser=aser;
	}
	
	
	
	@RequestMapping("/adminlogin")
	public String loginPage(Model model,Admin admin)
	{
		model.addAttribute("admin",admin);
		return "alogin";
	}
	
	@RequestMapping("/admindashboard")
	public String bdashboard()
	{
		return "admindashboard";
	}	
	@RequestMapping(value="/adminsubmit", method=RequestMethod.POST)
	public String loginSubmit(@Valid @ModelAttribute("admin") Admin ad, BindingResult bindingResult,HttpServletResponse res,HttpSession session) throws IOException
	{
		PrintWriter out = res.getWriter();
		if(bindingResult.hasErrors())
		{
			
			System.out.println("error");
			return "alogin";
			
		}
		else {
			boolean x = aser.logintest(ad);
			System.out.println(x);
			if(x) {
				return "admindashboard";
			}
			else {
			   // out.println("<center><h3 style='color:red'>Invalid Credentials</h3></center>");
				session.setAttribute("msg", "Invalid Credentials");
				return "alogin";
			}
		}
		
		
		
	}

}
