package com.qsp.theatre_management_system.exception;

public class PaymentNotFound extends RuntimeException {

	private String msg = "PaymentNotFound";

	public String getMsg() {
		return msg;
	}

}
