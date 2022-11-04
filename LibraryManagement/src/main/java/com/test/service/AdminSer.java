package com.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Admin;


@Service
@Transactional
public class AdminSer {
	
	@Autowired
	private AdminService ads;

	public AdminSer()
	{
		
	}
	
    
	
public boolean logintest(Admin ad) {
	
		
		List<Admin> result1 = ads.findallobjects();
		System.out.println(result1.size());
		for (Admin ad1 : result1)
		{
			System.out.println(ad1.getUname());
        	if(ad1.getUname().equals(ad.getUname()))
        	{
        		System.out.println("gyjkgkj");
        		if(ad1.getPassword().equals(ad.getPassword()))
        		{
        			return true;
        		}
        		return false;
        	}
        }
		
		return false;
	}
	
	

}
