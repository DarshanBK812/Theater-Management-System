package com.qsp.theatre_management_system.dto;

import java.sql.Time;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private Time movieDuration;
	private String movieGener;
	private String movieType;
	private String movieLanguage;

	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Ticket> ticket;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Time getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(Time movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieGener() {
		return movieGener;
	}

	public void setMovieGener(String movieGener) {
		this.movieGener = movieGener;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	

}
