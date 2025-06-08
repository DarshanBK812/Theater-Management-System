package com.qsp.theatre_management_system.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String modeOfPayment;
	private String transactionId;
	private Time paymentTime;
	private double paymentAmout;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Time getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Time paymentTime) {
		this.paymentTime = paymentTime;
	}
	public double getPaymentAmout() {
		return paymentAmout;
	}
	public void setPaymentAmout(double paymentAmout) {
		this.paymentAmout = paymentAmout;
	}
	

}
