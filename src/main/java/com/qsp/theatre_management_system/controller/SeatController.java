package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.dto.Seat;
import com.qsp.theatre_management_system.service.SeatService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class SeatController {

	@Autowired
	SeatService seatService;

	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}

	@GetMapping("/fetchSeatById")
	public ResponseStructure<Seat> fetchSeatById(@RequestParam int seatId) {
		return seatService.fetchSeatById(seatId);
	}

	@GetMapping("/fetchAllSeat")
	public ResponseStructureForAll<Seat> fetchAllSeat() {
		return seatService.fetchAllSeat();
	}

	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatId) {
		return seatService.deleteSeatById(seatId);
	}

	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldseatId, @RequestBody Seat newSeat) {
		return seatService.updateSeatById(oldseatId, newSeat);
	}
	
	@PutMapping("/addExisitingViewerToExisitingSeat")
	public ResponseStructure<Seat> addExisitingViewerToExisitingSeat(@RequestParam int seatId ,@RequestParam  int viewerId) {
		return seatService.addExisitingViewerToExisitingSeat(seatId, viewerId);
	}


}
