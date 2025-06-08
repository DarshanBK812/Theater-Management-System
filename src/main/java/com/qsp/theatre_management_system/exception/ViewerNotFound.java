package com.qsp.theatre_management_system.exception;

public class ViewerNotFound extends RuntimeException {
	
	private String msg = "ViewerNotFound";
	
	public String getMsg() {
		return msg;
	}

}
