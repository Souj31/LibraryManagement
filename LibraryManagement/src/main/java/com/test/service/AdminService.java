package com.test.service;

import java.util.List;

import com.test.model.Admin;
import com.test.model.UserR;

public interface AdminService { 
	
	Admin saveAdmin(Admin admin);
	
	
	Admin updateAdmin(Admin admin);
	
	public List<Admin> findallobjects();

}
