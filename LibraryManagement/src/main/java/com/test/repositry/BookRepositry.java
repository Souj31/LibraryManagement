package com.test.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.model.Book;


@Repository
public interface BookRepositry extends JpaRepository<Book, Integer>{
	
	//Custom query
	 @Query(value = "select * from book  where book_name like %:keyword% or book_author like %:keyword%", nativeQuery = true)
	 Book findByKeyword(@Param("keyword") String keyword);
	 
	 @Query(value = "select * from book where book_name like %:keyword%", nativeQuery = true)
	 Book ReturnedBook(@Param("keyword") String keyword);
	

}
