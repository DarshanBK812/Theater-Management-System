package com.qsp.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.TheaterDao;
import com.qsp.theatre_management_system.dto.Branch;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Theater;
import com.qsp.theatre_management_system.exception.TheaterNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class TheaterService {

	@Autowired
	TheaterDao theaterDao;

	@Autowired
	ResponseStructure<Theater> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Theater> responseStructureForAll;

	public ResponseStructure<Theater> saveTheater(Theater theater) {
		responseStructure.setMessage("Theater saved successfully in DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(theaterDao.saveTheater(theater));
		return responseStructure;
	}

	public ResponseStructure<Theater> fetchTheaterById(int theaterId) {
		Theater theater = theaterDao.fetchTheaterById(theaterId);
		if(theater != null) {
			responseStructure.setMessage("Theater fetched successfully from DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(theaterDao.fetchTheaterById(theaterId));
			return responseStructure;
		} else {
			throw new TheaterNotFound();
		}
	}

	

	public ResponseStructureForAll<Theater> fetchAllTheater() {
		responseStructureForAll.setMessage("All the Theater fetched successfully from DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(theaterDao.fetchAllTheater());
		return responseStructureForAll;
		

	}

	public ResponseStructure<Theater> deleteTheaterById(int theaterId) {
		responseStructure.setMessage("theater deleted from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theaterDao.deleteTheaterById(theaterId));
		return responseStructure;
	}
	
	public ResponseStructure<Theater> updateTheaterById(int oldTheaterId , Theater  newTheater) {
		responseStructure.setMessage("theater updated inthe DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theaterDao.updateOwnerById(oldTheaterId, newTheater));
		return responseStructure;
	}


	public ResponseStructure<Theater> addExistingBranchToExistingTheater(int branchId, int theaterId) {
		responseStructure.setMessage("Branch is added to Theater successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theaterDao.addExistingBranchToExistingTheater(branchId, theaterId));
		return responseStructure;

	}

	public ResponseStructure<Theater> addNewBranchToExistedTheater(Branch newBranch, int theaterId) {
		responseStructure.setMessage("new Branch is added to Theater successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theaterDao.addNewBranchToExistedTheater(newBranch, theaterId));
		return responseStructure;
		
	}
	
	public ResponseStructure<Theater> addExistingViewrToExistingThater(int theaterId, int viwerId) {
		responseStructure.setMessage("new Branch is added to Theater successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theaterDao.addExistingViewrToExistingThater(theaterId, viwerId));
		return responseStructure;
		
	}


}
