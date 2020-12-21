package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.MovieDao;
import com.cg.entity.Movie;
import com.cg.exception.MovieException;
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	@Override
	public List<Movie> viewAllMovies() {
		// TODO Auto-generated method stub
		return movieDao.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDao.saveAndFlush(movie);
	}

	@Override
	public List<Movie> searchBasedOnGenere(String genere) throws MovieException {
		// TODO Auto-generated method stub
		
		
			
		return movieDao.search(genere);
	}
	
	
}
