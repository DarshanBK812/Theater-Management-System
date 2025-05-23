package com.qsp.theatre_management_system.exception;

public class ManagerNotFound extends RuntimeException {
	
	private String msg = "ManagerNotFound";
	public String getMsg() {
		return msg;
	}

}
