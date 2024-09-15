package com.movies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.model.UserDetails;
import com.movies.model.authenticate;
import com.movies.service.userService;
@RestController
public class userController {
	@Autowired
	private userService uService;
	
	@PostMapping(value = "/toRegister")
	public UserDetails Register(@RequestBody @Valid UserDetails user) throws Exception {
		return  uService.toRegister(user);
	}

	
	  @PostMapping(value = "forLogin") 
	  public UserDetails login(@RequestBody @Valid authenticate user) throws Exception {
		  return uService.toLogin(user);
	}
	 
	 
	@GetMapping(value = "listOfUsers")
	public List<UserDetails> listOfusers(){
		return  uService.allUsers();
	}


}
