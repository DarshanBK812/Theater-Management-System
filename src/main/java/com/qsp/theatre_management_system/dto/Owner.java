package com.qsp.theatre_management_system.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity//create a table 
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private int ownerAge;
	private long ownerPhone;
	private double ownerNetWorth;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Theater theater;
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerAge() {
		return ownerAge;
	}
	public void setOwnerAge(int ownerAge) {
		this.ownerAge = ownerAge;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public double getOwnerNetWorth() {
		return ownerNetWorth;
	}
	public void setOwnerNetWorth(double ownerNetWorth) {
		this.ownerNetWorth = ownerNetWorth;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
	
	
	

}
