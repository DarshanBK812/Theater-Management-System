package com.qsp.theatre_management_system.dto;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
@Table(name = "screens")
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;

	@Column(name = "screen_number", nullable = false)
	private int screenNumber;

	@Column(name = "screen_type")
	private String screenType;

	@Column(name = "screen_size")
	private double screenSize;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	Movie movie;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getScreenNumber() {
		return screenNumber;
	}

	public void setScreenNumber(int screenNumber) {
		this.screenNumber = screenNumber;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
	
	

}
