package com.qsp.theatre_management_system.dto;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchEmail;
	private long brancPhone;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	Manager manager;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	Adress adress;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	public long getBrancPhone() {
		return brancPhone;
	}
	public void setBrancPhone(long brancPhone) {
		this.brancPhone = brancPhone;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	
	
	

}
