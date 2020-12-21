package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Movie;
import com.cg.exception.MovieException;
import com.cg.service.MovieService;

@RestController
@CrossOrigin("*")
public class MovieController {

	@Autowired
	MovieService  movieService;
	
	@PostMapping("movie")
	public ResponseEntity<Movie>  addMovie(@RequestBody Movie movie)
	{
		Movie m = movieService.addMovie(movie);
		ResponseEntity<Movie>  re = new ResponseEntity<Movie>(m,HttpStatus.OK);
		return re;
	}
	
	
	
	@GetMapping("movie")
	public ResponseEntity<List<Movie>>  viewAllMovies()
	{
	  
		List<Movie> list = movieService.viewAllMovies();
		ResponseEntity<List<Movie>>  rt = new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	@GetMapping("movie/{id}")
	public  ResponseEntity<List<Movie>>  movieInGenere(@PathVariable("id") String genere) throws MovieException
	{
		
		ResponseEntity<List<Movie>>   rt = null;
		
		
		List<Movie> list = movieService.searchBasedOnGenere(genere);
		rt= new ResponseEntity<List<Movie>> (list,HttpStatus.OK);
		
		return rt;
	}
	
}