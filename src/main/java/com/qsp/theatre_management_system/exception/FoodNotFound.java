package com.qsp.theatre_management_system.exception;

public class FoodNotFound extends RuntimeException {
	
	private String msg = "FoodNotFound";
	public String getMsg() {
		return msg;
	}

}
