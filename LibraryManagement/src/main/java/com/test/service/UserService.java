package com.test.service;

import java.util.List;

import javax.validation.Valid;

import com.test.model.Book;
import com.test.model.UserR;

public interface UserService {

List<UserR> getAllUser();
	
UserR saveUser(UserR user);
	
UserR getUserById(int id);
	
UserR updateUser(UserR user);
	
void deleteUserById(int id);


public List<UserR> findallobjects();

List<UserR> displayuser();

List<UserR> searchBook();




}
