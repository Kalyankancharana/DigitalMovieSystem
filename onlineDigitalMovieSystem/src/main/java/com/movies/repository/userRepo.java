package com.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.movies.model.UserDetails;

public interface userRepo extends JpaRepository<UserDetails, Integer>{
	UserDetails findByEmail(String email);

	UserDetails findByUsername(String username);
	
	UserDetails findByRole(String role);

	  @Query("select m from UserDetails m where m.username = :username and m.password = :password ")
	  UserDetails authenticateuser(@Param("username") String username,@Param("password") String password);
	  
		/*
		 * @Query("select n from UserDetails n where n.role = :role ") UserDetails
		 * roleDetails(@Param("role") String role);
		 */
	 

	

}
