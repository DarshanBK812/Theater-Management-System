package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.PaymentDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Payment;
import com.qsp.theatre_management_system.exception.PaymentNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Payment> responseStructureForAll;

	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setMessage("Payment saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(paymentDao.savePayment(payment));
		return responseStructure;
	}

	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		
		if(payment != null) {
			responseStructure.setMessage("Payment fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return responseStructure;
		} else {
			throw new PaymentNotFound();
		}
	}

	public ResponseStructureForAll<Payment> fetchAllPayment() {
		responseStructureForAll.setMessage("All Payment fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(paymentDao.fetchAllPayment());
		return responseStructureForAll;
	}

	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		responseStructure.setMessage(" Payment deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return responseStructure;
	}

	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId, Payment payment) {
		responseStructure.setMessage("Payment updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, payment));
		return responseStructure;
	}

}
