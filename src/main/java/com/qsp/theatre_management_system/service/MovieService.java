package com.qsp.theatre_management_system.service;

import java.util.List;

import javax.naming.LimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.MovieDao;
import com.qsp.theatre_management_system.dao.TicketDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.dto.Ticket;
import com.qsp.theatre_management_system.exception.LimitExceeds;
import com.qsp.theatre_management_system.exception.MovieNotFound;
import com.qsp.theatre_management_system.exception.ResourcesNotFound;
import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;

	@Autowired
	ResponseStructure<Movie> responseStructure;

	@Autowired
	ResponseStructureForAll<Movie> responseStructureForAll;

	@Autowired
	TicketDao ticketDao;

	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setMessage("Movie saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;
	}

	public ResponseStructure<Movie> fetchMovieById(int movieId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		if (movie != null) {
			responseStructure.setMessage("Movie fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(movieDao.fetchMovieById(movieId));
			return responseStructure;
		} else {
			throw new MovieNotFound();
		}
	}

	public ResponseStructureForAll<Movie> fetchAllMovie() {
		responseStructureForAll.setMessage("All Movie fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(movieDao.fetchAllMovie());
		return responseStructureForAll;
	}

	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		responseStructure.setMessage(" Movie deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(movieDao.deleteMovieById(movieId));
		return responseStructure;
	}

	public ResponseStructure<Movie> updateMovieById(int oldMovieId, Movie movie) {
		responseStructure.setMessage("Movie updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(movieDao.updateMovieById(oldMovieId, movie));
		return responseStructure;
	}

	public ResponseStructure<Movie> addExistingTicketToExictedMovie(int movieId, int ticketId) {

		Movie movie = movieDao.fetchMovieById(movieId);
		Ticket ticket = ticketDao.fetchTicketById(ticketId);

		if (ticket == null || movie == null) {
			throw new ResourcesNotFound();
		}

		List<Ticket> list = movie.getTicket();
		if (list.size() >= 5) {
			throw new LimitExceeds();
		}

		list.add(ticket);
		movie.setTicket(list);

		responseStructure.setMessage("addExistingTicketToExictedMovie");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(movieDao.saveMovie(movie));
		
		return responseStructure;
	}

	public ResponseStructure<Movie> updateMovieByName(String oldaName, Movie newMovie) {
		
		responseStructure.setMessage("Updated the movie By its Name in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(movieDao.updateMovieByName(oldaName, newMovie));
		return responseStructure;
	}

}
