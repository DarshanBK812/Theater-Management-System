package com.qsp.theatre_management_system.dto;

import javax.swing.text.View;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	private String seatType;
	private String seatColor;
	private String seatNumber;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	Viewer view;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getSeatColor() {
		return seatColor;
	}

	public void setSeatColor(String seatColor) {
		this.seatColor = seatColor;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Viewer getView() {
		return view;
	}

	public void setView(Viewer view2) {
		this.view = view2;
	}
	

}
