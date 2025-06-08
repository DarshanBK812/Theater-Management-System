package com.qsp.theatre_management_system.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qsp.theatre_management_system.dto.Adress;

@Component
public class ResponseStructure<T> {
	
	private String message ;
	private int statuscode;
	private T data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statusCode) {
		this.statuscode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	

}
