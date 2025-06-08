package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.repo.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	MovieRepo movieRepo;

	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	public Movie fetchMovieById(int movieId) {
		Optional<Movie > movie = movieRepo.findById(movieId);
		if(movie.isEmpty()) {
			return null;
		}
		return movie.get();
	}

	public List<Movie> fetchAllMovie() {
		return movieRepo.findAll();
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = movieRepo.findById(movieId).get();
		movieRepo.delete(movie);
		return movie;
	}

	public Movie updateMovieById(int oldMovieId, Movie movie) {
		movie.setMovieId(oldMovieId);
		movieRepo.save(movie);
		return movie;
	}


}
