package com.test.repositry;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.model.Book;
import com.test.model.UBorrow;
import com.test.model.UserR;

@Transactional
public interface UserRRepositry  extends JpaRepository<UserR, Integer>{
	
	@Query(value = "select username from user",nativeQuery = true)
	 List<String> AllUserNaes();
	
	//Custom query
		 @Query(value = "select * from user  where firstname like %:keyword% ", nativeQuery = true)
		 UserR findByKeyword(@Param("keyword") String keyword);

}




