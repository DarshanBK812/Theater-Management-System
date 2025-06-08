package com.qsp.theatre_management_system.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class TheaterNotFound extends RuntimeException{
	
	private String msg = "Theater not found";
	
	 public String getMsg() {
		 return msg;
	 }

}
