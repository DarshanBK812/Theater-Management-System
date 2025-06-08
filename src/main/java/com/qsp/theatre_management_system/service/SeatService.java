package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.SeatDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.exception.SeatNotFound;
import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.repo.SeatRepo;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class SeatService {
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Seat> responseStructureForAll;
	

	public ResponseStructure<Seat> saveSeat(Seat employee) {
		responseStructure.setMessage("Seats saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(seatDao.saveSeat(employee));
		return responseStructure;
	}

	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if(seat != null) {
			responseStructure.setMessage("Seats fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(seatDao.fetchSeatById(seatId));
			return responseStructure;
		} else {
			throw new SeatNotFound();
		}
	}

	public ResponseStructureForAll<Seat> fetchAllSeat() {
		responseStructureForAll.setMessage("All the Seats fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(seatDao.fetchAllSeat());
		return responseStructureForAll;
	}

	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		responseStructure.setMessage("Seats deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(seatDao.deleteSeatById(seatId));
		return responseStructure;
	}

	public ResponseStructure<Seat> updateSeatById(int oldseatId, Seat newSeat) {
		responseStructure.setMessage("Seats updated successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(seatDao.updateSeatById(oldseatId, newSeat));
		return responseStructure;
	}
	
	public ResponseStructure<Seat> addExisitingViewerToExisitingSeat(int seatId , int viewerId) {
		responseStructure.setMessage("viwer saved successfully to seat in the DB ");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(seatDao.addExisitingViewerToExisitingSeat(seatId, viewerId));
		return responseStructure;
	}



}
