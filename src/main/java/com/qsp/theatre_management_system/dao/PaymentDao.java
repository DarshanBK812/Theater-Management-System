package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Payment;
import com.qsp.theatre_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo paymentRepo;

	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> payment = paymentRepo.findById(paymentId);
		if (payment.isEmpty()) {
			return null;
		} else
			return payment.get();
	}

	public List<Payment> fetchAllPayment() {
		return paymentRepo.findAll();
	}

	public Payment deletePaymentById(int paymentId) {
		Payment payment = paymentRepo.findById(paymentId).get();
		paymentRepo.delete(payment);
		return payment;
	}

	public Payment updatePaymentById(int oldPaymentId, Payment payment) {
		payment.setPaymentId(oldPaymentId);
		paymentRepo.save(payment);
		return payment;
	}
	
	

}
