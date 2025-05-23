package com.qsp.theatre_management_system.exception;

public class SeatNotFound extends RuntimeException {
	
	private String msg = " SeatNotFound";
	
	public String getMsg() {
		return msg;
	}

}
