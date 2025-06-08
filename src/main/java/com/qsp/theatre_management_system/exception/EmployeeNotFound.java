package com.qsp.theatre_management_system.exception;

public class EmployeeNotFound extends RuntimeException{
	
	private String msg = "Employee not found";
	
	public String getMsg() {
		return msg;
	}

}
