package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dao.OwnerDao;
import com.qsp.theatre_management_system.dto.Owner;
import com.qsp.theatre_management_system.service.OwnerService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@DeleteMapping("/deleteOnerById")
	public ResponseStructure<Owner> deleteOnerById(@RequestParam int onwerId) {
		return ownerService.deleteOwnerByid(onwerId);
	}

	@PutMapping("/saveExistingOwnerToExistingTheater")
	public Owner saveExistingOwnerToExistingTheater(@RequestParam int ownerId, @RequestParam int theaterId) {
		return ownerService.saveExistingOwnerToExistingTheater(ownerId, theaterId);

	}

	@GetMapping("/fetchAllOwner")
	public ResponseStructureForAll<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner owner) {
		return ownerService.updateOwnerById(oldOwnerId, owner);

	}

}
