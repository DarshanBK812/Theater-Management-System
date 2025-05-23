package com.qsp.theatre_management_system.exception;

public class MovieNotFound extends RuntimeException {
	
	private String msg = "MovieNotFound";
	
	public String getMsg() {
		return msg;
	}

}
