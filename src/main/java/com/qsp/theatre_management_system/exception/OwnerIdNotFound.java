package com.qsp.theatre_management_system.exception;

public class OwnerIdNotFound extends RuntimeException {

	private String message="Id not found";

	public String getMessage() {
		return message;
	}
}
