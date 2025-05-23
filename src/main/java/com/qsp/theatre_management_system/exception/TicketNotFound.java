package com.qsp.theatre_management_system.exception;

public class TicketNotFound extends RuntimeException {
	
	private String msg = "TicketNotFound";
	
	public String getMsg() {
		return msg;
	}

}
