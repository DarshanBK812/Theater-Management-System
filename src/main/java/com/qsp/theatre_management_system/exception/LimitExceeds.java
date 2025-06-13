package com.qsp.theatre_management_system.exception;

public class LimitExceeds extends RuntimeException {
	String str = "Ticket booking closed for this movie , Limit exceeds";

	public String limitExceeds() {
		return str;
	}

}
