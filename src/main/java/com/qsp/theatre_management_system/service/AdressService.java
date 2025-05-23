package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.AdressDao;
import com.qsp.theatre_management_system.dto.Adress;
import com.qsp.theatre_management_system.exception.AdressNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;
import com.qsp.theatre_management_system.dto.Adress;

@Service
public class AdressService {

	@Autowired
	AdressDao adressDao;

	@Autowired
	ResponseStructure<Adress> responseStructure;

	@Autowired
	ResponseStructureForAll<Adress> responseStructureForAll;

	public ResponseStructure<Adress> saveAdress(Adress adress) {
		responseStructure.setMessage("Adress saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(adressDao.saveAdress(adress));
		return responseStructure;
	}

	public ResponseStructure<Adress> fetchAdressById(int adressId) {
		
		Adress adress =  adressDao.fetchAdressById(adressId);
		if(adress != null) {
			responseStructure.setMessage("Adress fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(adressDao.fetchAdressById(adressId));
			return responseStructure;
		}
		else {
			throw new AdressNotFound();
		}
		
		
		
	}

	public ResponseStructureForAll<Adress> fetchAllAdress() {
		responseStructureForAll.setMessage("All the adress fetched succesfully from DB");
		responseStructureForAll.setStatuscode(HttpStatus.OK.value());
		responseStructureForAll.setAllData(adressDao.fetchAllAdress());
		return responseStructureForAll;

	}

	public ResponseStructure<Adress> deleteAdressById(int adressId) {
		responseStructure.setMessage(" Adress deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(adressDao.deleteAdressById(adressId));
		return responseStructure;
	}

	public ResponseStructure<Adress> updateAdressById(int oldAdressId, Adress adress) {
		responseStructure.setMessage("Adress updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(adressDao.updateAdressById(oldAdressId, adress));
		return responseStructure;
	}

}
