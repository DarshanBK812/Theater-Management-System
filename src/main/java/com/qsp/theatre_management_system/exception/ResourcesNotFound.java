package com.qsp.theatre_management_system.exception;

public class ResourcesNotFound extends RuntimeException {

	String msg = "resourcesNotFound";

	public String resourcesNotFound() {
		return msg;
	}
}
