package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Adress;
import com.qsp.theatre_management_system.dto.Adress;
import com.qsp.theatre_management_system.service.AdressService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class AdressController {

	@Autowired
	AdressService adressService;

	@PostMapping("/saveAdress")
	public ResponseStructure<Adress> saveAdress(@RequestBody Adress adress) {
		return adressService.saveAdress(adress);
	}

	@GetMapping("/fetchAdressById")
	public ResponseStructure<Adress> fetchAdressById(@RequestParam int adressId) {
		return adressService.fetchAdressById(adressId);
	}

	@GetMapping("/fetchAllAdress")
	public ResponseStructureForAll<Adress> fetchAllAdress() {
		return adressService.fetchAllAdress();
	}

	@DeleteMapping("/deleteAdressById")
	public ResponseStructure<Adress> deleteAdressById(@RequestParam int adressId) {
		return adressService.deleteAdressById(adressId);
	}

	@PutMapping("/updateAdressById")
	public ResponseStructure<Adress> updateAdressById(@RequestParam int oldAdressId,@RequestBody Adress adress) {
		return adressService.updateAdressById(oldAdressId, adress);
	}

}
