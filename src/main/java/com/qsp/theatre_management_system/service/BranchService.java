package com.qsp.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.BranchDao;
import com.qsp.theatre_management_system.dto.Branch;
import com.qsp.theatre_management_system.repo.BranchRepo;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructureForAll<Branch> responseStructureForAll;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setMessage("Bracnh is saved successfully in DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("fethed Branch done from the DB ");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return responseStructure;
		} else {
			throw new BrachNotFound();
		}

	}

	public ResponseStructureForAll<Branch> fetchAllBranch() {
		responseStructureForAll.setMessage("Fetched All the branches from DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(branchDao.fetchAllBranch());
		return responseStructureForAll;

	}

	public ResponseStructure<Branch> deleteBranchId(int branchId) {
		responseStructure.setMessage("Branch is deleted from DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranchId(branchId));
		return responseStructure;

	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		responseStructure.setMessage("Branch is updated in DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return responseStructure;
	}

	public ResponseStructure<Branch> saveExistingManagerToExistingBranch(int manaderId, int branchId) {
		responseStructure.setMessage("Manager is saved to Branch successfully in the DB ");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.saveExistingManagerToExistingBranch(manaderId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingAdressToExistingBranch(int adressId, int branchId) {
		responseStructure.setMessage("Adress is saved to Branch successfully in the DB ");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAdressToExistingBranch(adressId, branchId));
		return responseStructure;
	}
	
	

}
