package com.qsp.theatre_management_system.dto;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qsp.theatre_management_system.repo.ScreenRepo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class  Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String tickeType;
	private double ticketPrice;
	private String ticketNumber;

	@OneToOne
	@Cascade(CascadeType.ALL)
	Payment payment;
	
	
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTickeType() {
		return tickeType;
	}

	public void setTickeType(String tickeType) {
		this.tickeType = tickeType;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	

}
