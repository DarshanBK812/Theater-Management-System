package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Adress;
import com.qsp.theatre_management_system.repo.AdressRepo;

@Repository
public class AdressDao {

	@Autowired
	AdressRepo adressRepo;

	public Adress saveAdress(Adress adress) {
		return adressRepo.save(adress);
	}

	public Adress fetchAdressById(int adressId) {
//		return adressRepo.findById(adressId).get();
		Optional<Adress> adress =  adressRepo.findById(adressId);
		if(adress.isEmpty()) {
			return null;
		}
		else {
			return adress.get();
		}
	}

	public List<Adress> fetchAllAdress() {
		return adressRepo.findAll();
	}

	public Adress deleteAdressById(int adressId) {
		Adress adress = adressRepo.findById(adressId).get();
		adressRepo.delete(adress);
		return adress;
	}
	
	public Adress updateAdressById(int oldAdressId , Adress adress) {
		adress.setAdressId(oldAdressId);
		adressRepo.save(adress);
		return adress;
	}

}
