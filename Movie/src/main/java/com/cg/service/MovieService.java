package com.cg.service;

import java.util.List;

import com.cg.entity.Movie;
import com.cg.exception.MovieException;

public interface MovieService {

	public  List<Movie> viewAllMovies();
	public Movie addMovie(Movie movie);
	public List<Movie> searchBasedOnGenere(String genere) throws MovieException;
}
