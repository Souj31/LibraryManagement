package com.test.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.UserR;
import com.test.repositry.UserRRepositry;
import com.test.service.UserService;

@Repository
public class UserServiceImpl implements UserService{
	
	private UserRRepositry userRepositry;
	
	
	
	
	public UserServiceImpl(UserRRepositry userRepositry) {
		super();
		this.userRepositry = userRepositry;
	}

	@Override
	public List<UserR> getAllUser() {
		return userRepositry.findAll();
	}

	@Override
	public UserR saveUser(UserR user) {
		return userRepositry.save(user);
	}

	@Override
	public UserR getUserById(int id) {
		return userRepositry.findById(id).get();
	}

	@Override
	public UserR updateUser(UserR user) {
		return userRepositry.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		 userRepositry.deleteById(id);
		
	}

	@Override
	public List<UserR> findallobjects() {
		List<UserR> result = userRepositry.findAll();
		return result;
	}



	@Override
	public List<UserR> displayuser() {
		List<UserR> result = userRepositry.findAll();
		return result;
	
	}

	@Override
	public List<UserR> searchBook() {
		return userRepositry.findAll();
	}
		
}

