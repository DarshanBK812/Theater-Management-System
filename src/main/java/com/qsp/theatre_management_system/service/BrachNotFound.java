package com.qsp.theatre_management_system.service;

public class BrachNotFound extends RuntimeException {
	
	private String msg = "Branch not found";
	
	public String getMsg() {
		return msg;
	}

}
