package com.test.repositry;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Admin;

@Transactional
public interface AdminRepositry extends JpaRepository<Admin, Integer>{

}
