package com.qsp.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.OwnerDao;
import com.qsp.theatre_management_system.dao.TheaterDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Owner;
import com.qsp.theatre_management_system.dto.Theater;
import com.qsp.theatre_management_system.exception.OwnerIdNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Owner> responseStructureForAll;

	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setMessage("Owner save successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;

	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		
		if (owner != null) {
		
			responseStructure.setMessage("Owner fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			
			return responseStructure;

		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructure<Owner> deleteOwnerByid(int ownerId) {

		responseStructure.setMessage("Owner delete successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
		return responseStructure;

	}

	public ResponseStructureForAll<Owner> fetchAllOwner() {
		responseStructureForAll.setMessage("Fteched all the Owners From the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(ownerDao.fetchAllOwner());
		return responseStructureForAll;
	}

	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId, Owner owner) {
		responseStructure.setMessage("Owner updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, owner));
		return responseStructure;
	}

	public Owner saveExistingOwnerToExistingTheater(int ownerId, int theaterId) {

		return ownerDao.saveExistingOwnerToExistingTheater(ownerId, theaterId);

	}
}
