package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dao.IncomeDao;
import com.qsp.theatre_management_system.dto.Income;
import com.qsp.theatre_management_system.service.IncomeService;
import com.qsp.theatre_management_system.util.ResponseStructure;

@RestController
public class IncomeController {

	@Autowired
	IncomeService incomeService;

	@PostMapping("/saveIncome")
	public ResponseStructure<Income> saveIncome(@RequestBody Income income) {
		return incomeService.saveIncome(income);
	}

	@GetMapping("/fetchIncomeById")
	public ResponseStructure<Income> fetchIncomeById(@RequestParam int incomeId) {
		return incomeService.fetchIncomeById(incomeId);
	}

}
