package com.movies.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.model.Movies;
import com.movies.model.UserDetails;

import com.movies.repository.moviesRepo;
import com.movies.repository.userRepo;


@Service
public class movieService {
	
	@Autowired 
	  private userRepo userrepository;
	@Autowired 
	  private moviesRepo movierepository;
	
//	to updateMovie
	public void toUpdateMovie(int id,String date) {
		@SuppressWarnings("deprecation")
		Movies movie = movierepository.getById(id);
		movie.setRelaseDate(date);
		movierepository.save(movie);
	}
	
//	genre of movies
	public Stream<Movies> genreofMovie(String genre){
		List<Movies> movies = movierepository.findAll();
		Stream<Movies> gmovie = movies.stream().filter(m -> m.getGenre().toLowerCase().contentEquals(genre));
		return gmovie;
	}
	// to add new movie
		public Movies addNewmovie(Movies movie) 
		{
			return movierepository.save(movie);
		}
	
//to get all movies 
	public List<Movies> getMovies() {
		return movierepository.findAll();
	}
	
// to delete or remove movies
	public void toDelete(int id) {
		@SuppressWarnings("deprecation")
		Movies movie = movierepository.getById(id);
		movierepository.delete(movie);
		
	}
	
//	to delete favourite movies
	
	public void deleteFavById(int uid,int mid) throws Exception {
		@SuppressWarnings("deprecation")
		UserDetails user = userrepository.getById(uid);
		if(user!=null) {
			@SuppressWarnings("deprecation")
			Movies movie = movierepository.getById(mid);
			if(user.getFavourites().contains(movie)) {
				user.getFavourites().remove(movie);
				userrepository.save(user);
			}else {
				throw new Exception("movie is not in favourites");
			}
		}else {
			throw new Exception("no user with the id");
		}
	}
	
//	to add favourite movies
	public void addMovietoFav(int uid,int mid) throws Exception {
		@SuppressWarnings("deprecation")
		UserDetails user = userrepository.getById(uid);
		if(user!=null) {
			@SuppressWarnings("deprecation")
			Movies movie = movierepository.getById(mid);
			if(! user.getFavourites().contains(movie)) {
				user.AddFavourites(movie);
				userrepository.save(user);
			}else {
				throw new Exception("movie already in favourites");
			}
		}else {
			throw new Exception("no user with the id");
		}
		
	}

	  
	  
	
	 

}
