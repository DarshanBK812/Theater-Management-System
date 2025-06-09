package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Branch;
import com.qsp.theatre_management_system.dto.Theater;
import com.qsp.theatre_management_system.service.TheaterService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class TheaterController {

	@Autowired
	TheaterService theaterService;

	@PostMapping("/saveTheater")
	public ResponseStructure<Theater> saveTheater(@RequestBody Theater theater) {
		return theaterService.saveTheater(theater);
	}

	@GetMapping("/fetchTheaterById")
	public ResponseStructure<Theater> fetchTheaterById(@RequestParam int theaterId) {
		return theaterService.fetchTheaterById(theaterId);

	}

	@GetMapping("/fetchAllTheater")
	public ResponseStructureForAll<Theater> fetchAllTheater() {
		return theaterService.fetchAllTheater();
	}

	@DeleteMapping("/deleteTheaterById")
	public ResponseStructure<Theater> deleteTheaterById(@RequestParam int theaterId) {
		return theaterService.deleteTheaterById(theaterId);
	}

	@PutMapping("/updateTheaterById")
	public ResponseStructure<Theater> updateTheaterById(@RequestParam int oldTheaterId,
			@RequestBody Theater newTheater) {
		return theaterService.updateTheaterById(oldTheaterId, newTheater);
	}

	@PostMapping("/addExistingBranchToExistingTheater")
	public ResponseStructure<Theater> addExistingBranchToExistingTheater(@RequestParam int branchId, @RequestParam int theaterId) {
		return theaterService.addExistingBranchToExistingTheater(branchId, theaterId);
	}

	@PostMapping("/addNewBranchToExistedTheater")
	public ResponseStructure<Theater> addNewBranchToExistedTheater(@RequestBody Branch newBranch, @RequestParam int theaterId) {
		return theaterService.addNewBranchToExistedTheater(newBranch, theaterId);
	}
	
	@PostMapping("/addExistingViewrToExistingThater")
	public ResponseStructure<Theater> addExistingViewrToExistingThater(@RequestParam int theaterId,@RequestParam int viwerId) {
		return theaterService.addExistingViewrToExistingThater(theaterId, viwerId);
	}

}
