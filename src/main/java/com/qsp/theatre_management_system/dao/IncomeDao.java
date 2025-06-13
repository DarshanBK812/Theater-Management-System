package com.qsp.theatre_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Income;
import com.qsp.theatre_management_system.repo.IncomeRepo;

@Repository
public class IncomeDao {

	@Autowired
	IncomeRepo incomeRepo;

	public Income saveIncome(Income income) {
		return incomeRepo.save(income);
	}

	public Income fetchIncomeById(int incomeId) {

		Optional<Income> income = incomeRepo.findById(incomeId);

		if (income.isEmpty()) {
			return null;
		} else {
			return income.get();
		}
	}

}
