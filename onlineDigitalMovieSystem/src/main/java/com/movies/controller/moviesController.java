package com.movies.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.model.Movies;

import com.movies.service.movieService;



@RestController
public class moviesController {
	@Autowired
	private movieService mService;
	
	@PostMapping(value = "admin /addnewMovie")
	public Movies addnewMovie(@RequestBody @Valid Movies movie) {
		return mService.addNewmovie(movie);
	}
	@GetMapping(value="user/listOfmovies")
	public List<Movies> listOfmovies(){
		return mService.getMovies();
	}
	@PutMapping(value="admin/updatemovie/{id}/{date}")
	public void ToupdateMovie(@PathVariable("id") int id,@PathVariable("date") String date) {
		mService.toUpdateMovie(id, date);
	}
	@GetMapping(value="user/MoviesbyGenre/{genre}")
	public Stream<Movies> moviesGenre(@PathVariable("genre") String genre){
		return mService.genreofMovie(genre);
	}
	@DeleteMapping(value = "admin/toDeleteMovie/{id}")
	public void deleteMovieById(@PathVariable("id") int id) {
		mService.toDelete(id);
	}
	@PutMapping(value="user/addMoviesTofav/{uid}/{mid}")
	public void favMovies(@PathVariable("uid") int uid,@PathVariable("mid")  int mid) throws Exception {
		mService.addMovietoFav(uid, mid);
	}
	@PutMapping(value = "user/deletefav/{uid}/{mid}")
	public void deletefav(@PathVariable("uid") int uid,@PathVariable("mid") int mid) throws Exception {
		mService.deleteFavById(uid, mid);
	}
	
}
