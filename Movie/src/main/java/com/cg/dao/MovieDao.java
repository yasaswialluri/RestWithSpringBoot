package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie,Integer>{

	@Query("select movie from Movie movie where genere=:id")
	public List<Movie> search(@Param("id") String genere);
}
