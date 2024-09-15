package com.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String relaseDate;
	@NotEmpty
	
	private String director;
	@NotEmpty
	private String review ;
	@NotEmpty
	private String genre;
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movies(int id, @NotEmpty String name, @NotEmpty String relaseDate,@NotEmpty  String director,
			@NotEmpty String review, @NotEmpty String genre) {
		super();
		this.id = id;
		this.name = name;
		this.relaseDate = relaseDate;
		this.director = director;
		this.review = review;
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelaseDate() {
		return relaseDate;
	}
	public void setRelaseDate(String relaseDate) {
		this.relaseDate = relaseDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
	
