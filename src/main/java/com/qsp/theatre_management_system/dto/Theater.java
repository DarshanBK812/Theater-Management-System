package com.qsp.theatre_management_system.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theaterId;
	private String theaterName;
	private String theaterEmail;
	private long theaterPhone;
	private String theaterGST;

	@OneToMany(cascade =  CascadeType.ALL)
	private List<Branch> branch;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Viewer> viewers;
	
	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterEmail() {
		return theaterEmail;
	}

	public void setTheaterEmail(String theaterEmail) {
		this.theaterEmail = theaterEmail;
	}

	public long getTheaterPhone() {
		return theaterPhone;
	}

	public void setTheaterPhone(long theaterPhone) {
		this.theaterPhone = theaterPhone;
	}

	public String getTheaterGST() {
		return theaterGST;
	}

	public void setTheaterGST(String theaterGST) {
		this.theaterGST = theaterGST;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public List<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(List<Viewer> viewers) {
		this.viewers = viewers;
	}
	
	
	

}
