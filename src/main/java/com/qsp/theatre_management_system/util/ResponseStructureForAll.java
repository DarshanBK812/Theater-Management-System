package com.qsp.theatre_management_system.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructureForAll<T> {
	
	private String message;
	private int statuscode;
	private List<T> allData;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	
	public List<T> getAllData() {
		return allData;
	}
	public void setAllData(List<T> data) {
		this.allData = data;
	}
	
	
	
	

}
