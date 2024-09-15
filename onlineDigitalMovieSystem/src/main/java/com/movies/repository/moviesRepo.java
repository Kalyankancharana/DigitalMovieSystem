package com.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.model.Movies;

@Repository
public interface moviesRepo extends JpaRepository<Movies, Integer> {

}
