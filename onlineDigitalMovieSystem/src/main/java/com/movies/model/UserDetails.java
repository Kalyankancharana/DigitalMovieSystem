package com.movies.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.movies.model.Movies;
@Entity
@Table(name = "user")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	
	private String username;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String firstName;
	
	private String lastName;
	@NotEmpty
	
	private String password;
	@NotEmpty
	
	private String phone;
	@NotEmpty
	private String role;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private List<Movies> favourites;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(int id,@NotEmpty String username,@NotEmpty @Email  String email,@NotEmpty String firstName, String lastName,
			@NotEmpty String password,@NotEmpty  String phone,@NotEmpty String role,List<Movies> favourites)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.role=role;
		this.favourites = favourites;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Movies> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Movies> favourites) {
		this.favourites = favourites;
	}
	public void AddFavourites(Movies movie) {
		if(this.favourites == null) {
			this.favourites= new ArrayList<Movies>();
		}
		this.favourites.add(movie);
	}

}
