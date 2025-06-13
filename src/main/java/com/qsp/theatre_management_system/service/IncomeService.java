package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.IncomeDao;
import com.qsp.theatre_management_system.dto.Income;
import com.qsp.theatre_management_system.exception.IncomeNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;

@Service
public class IncomeService {

	@Autowired
	IncomeDao incomeDao;

	@Autowired
	ResponseStructure<Income> responseStructure;

	public ResponseStructure<Income> saveIncome(Income income) {
		responseStructure.setMessage("Income is inserted successfully to DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(incomeDao.saveIncome(income));

		return responseStructure;
	}

	public ResponseStructure<Income> fetchIncomeById(int incomeId) {
		Income income = incomeDao.fetchIncomeById(incomeId);
		if (income != null) {
			responseStructure.setMessage("income fetched successfully from the db");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(incomeDao.fetchIncomeById(incomeId));
			return responseStructure;
		} else {
			throw new IncomeNotFound();
		}
	}

}
