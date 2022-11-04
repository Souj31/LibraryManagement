package com.test.service.impl;

import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.Admin;
import com.test.repositry.AdminRepositry;
import com.test.service.AdminService;

@Repository
public class AdminServiceImpl implements AdminService{
	
	private AdminRepositry adminRepositry;
	

	public AdminServiceImpl(AdminRepositry adminRepositry) {
		this.adminRepositry = adminRepositry;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepositry.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepositry.save(admin);
	}

	@Override
	public List<Admin> findallobjects() {
		List<Admin> result = adminRepositry.findAll();
		return result;
	}

}
