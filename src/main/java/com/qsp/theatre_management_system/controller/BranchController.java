package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Branch;
import com.qsp.theatre_management_system.service.BranchService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@GetMapping("/fetchAllBranch")
	public ResponseStructureForAll<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@DeleteMapping("/deleteBranchId")
	public ResponseStructure<Branch> deleteBranchId(@RequestParam int branchId) {
		return branchService.deleteBranchId(branchId);
	}

	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@PutMapping("/saveExistingManagerToExistingBranch")
	public ResponseStructure<Branch> saveExistingManagerToExistingBranch(@RequestParam int manaderId,@RequestParam  int branchId) {
		return branchService.saveExistingManagerToExistingBranch(manaderId, branchId);
	}

	@PutMapping("/addExistingAdressToExistingBranch")
	public ResponseStructure<Branch> addExistingAdressToExistingBranch(@RequestParam int adressId,@RequestParam  int branchId) {
		return branchService.addExistingAdressToExistingBranch(adressId, branchId);
	}

}
