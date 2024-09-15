package com.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.model.UserDetails;
import com.movies.model.authenticate;
import com.movies.repository.moviesRepo;
import com.movies.repository.userRepo;

@Service
public class userService {

	@Autowired
	private userRepo userrepository;
	@Autowired
	private moviesRepo movierepo;
	
//	for all users
	public List<UserDetails> allUsers()
	{
		return userrepository.findAll();
	}

//	for registration
	public UserDetails toRegister(UserDetails user) throws Exception {
		
		UserDetails user1 = userrepository.findByEmail(user.getEmail());
		UserDetails user2 = userrepository.findByUsername(user.getUsername());
		if (user1 != null && user2  != null) {
			throw new Exception("Already Existed please do login");
		} else {
			return userrepository.save(user);
		}
	}

//	for login
	
	  public UserDetails toLogin(authenticate request) throws Exception {
	  UserDetails user = userrepository.authenticateuser(request.getUsername(),request.getPassword()); 
	
	  if (user != null)
	  {
		  return user;
	  } 
	  else { throw new Exception("either username or password are incorrect"); } 
	  }
	  

	 


	
	
	

}
