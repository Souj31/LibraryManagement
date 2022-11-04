package com.test.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.model.Book;
import com.test.model.UBorrow;

@Transactional
public interface UBorrowRepositry extends JpaRepository<UBorrow, Integer>{
	
	@Query(value = "select * from uborrow  where uname like %:keyword%", nativeQuery = true)
	 List<UBorrow> userborrow(@Param("keyword") String keyword);
	
	@Query(value = "select book_name from uborrow  where uname like %:keyword%", nativeQuery = true)
	 List<String> samebookborrow(@Param("keyword") String keyword);
	

}
