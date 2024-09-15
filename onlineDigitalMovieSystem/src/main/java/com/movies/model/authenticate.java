package com.movies.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class authenticate {
	@NotEmpty
	
	private String username;
	@NotEmpty
	
	private String password;
	/*
	 * @NotEmpty private String role;
	 */

	public authenticate(@NotEmpty  String username,
			@NotEmpty  String password)
			{
		super();
		this.username = username;
		this.password = password;
		/* this.role=role; */
	}
	public authenticate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
