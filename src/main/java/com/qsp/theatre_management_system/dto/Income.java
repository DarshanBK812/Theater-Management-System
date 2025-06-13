package com.qsp.theatre_management_system.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incomeId;
	private String incomeType;
	private String incomeAnnual;

	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeAnnual() {
		return incomeAnnual;
	}

	public void setIncomeAnnual(String incomeAnnual) {
		this.incomeAnnual = incomeAnnual;
	}

}
