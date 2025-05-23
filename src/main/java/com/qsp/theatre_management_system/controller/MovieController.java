package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.service.MovieService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/fetchMovieById")
	public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
	}

	@GetMapping("/fetchAllMovie")
	public ResponseStructureForAll<Movie> fetchAllMovie() {
		return movieService.fetchAllMovie();
	}

	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}

	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie movie) {
		return movieService.updateMovieById(oldMovieId, movie);
	}

}
