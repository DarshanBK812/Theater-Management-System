package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.repo.SeatRepo;
import com.qsp.theatre_management_system.repo.ViewerRepo;

@Repository
public class SeatDao {
	
	@Autowired
	SeatRepo seatRepo;
	
	@Autowired
	ViewerRepo viewerRepo;
	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	
	public Seat fetchSeatById(int seatId) {
		Optional<Seat> seat = seatRepo.findById(seatId);
		if(seat.isEmpty()) {
			return null;
		} else {
			return seat.get();
		}
	}
	
	public List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}

	public Seat deleteSeatById(int seatId) {
		Seat employee = seatRepo.findById(seatId).get();
		seatRepo.delete(employee);
		return employee;
	}

	public Seat updateSeatById(int oleEmpId, Seat newSeat) {
		newSeat.setSeatId(oleEmpId);
		seatRepo.save(newSeat);
		return newSeat;

	}
	
	public Seat addExisitingViewerToExisitingSeat(int seatId , int viewerId) {
		Seat seat = fetchSeatById(seatId);
		Viewer view =  viewerRepo.findById(viewerId).get();
		seat.setView(view);
		return  saveSeat(seat);	
	}
	

}
