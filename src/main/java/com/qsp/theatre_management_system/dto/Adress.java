package com.qsp.theatre_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adressId;
	private String adressStreet;
	private String adressLandamark;
	private String adressState;
	private int adressPincode;

	public String getAdressStreet() {
		return adressStreet;
	}

	public void setAdressStreet(String adressStreet) {
		this.adressStreet = adressStreet;
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getAdressSt() {
		return adressStreet;
	}

	public void setAdressSt(String adressSt) {
		this.adressStreet = adressSt;
	}

	public String getAdressLandamark() {
		return adressLandamark;
	}

	public void setAdressLandamark(String adressLandamark) {
		this.adressLandamark = adressLandamark;
	}

	public String getAdressState() {
		return adressState;
	}

	public void setAdressState(String adressState) {
		this.adressState = adressState;
	}

	public int getAdressPincode() {
		return adressPincode;
	}

	public void setAdressPincode(int adressPincode) {
		this.adressPincode = adressPincode;
	}

}
