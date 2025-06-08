package com.qsp.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.ManagerDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Manager;
import com.qsp.theatre_management_system.exception.ManagerNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Manager> responseStructureForAll;

	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setMessage("Manager saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}

	public ResponseStructure<Manager> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if(manager != null) {
			responseStructure.setMessage("Manager fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return responseStructure;
		} else {
			throw new ManagerNotFound();
		}
	}

	public ResponseStructureForAll<Manager> fetchAllManager() {
		responseStructureForAll.setMessage("All Manager fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(managerDao.fetchAllManager());
		return responseStructureForAll;
	}

	public ResponseStructure<Manager> deleteManagerById(int managerId) {
		responseStructure.setMessage(" Manager deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return responseStructure;
	}

	public ResponseStructure<Manager> updateManagerById(int oldManagerId, Manager manager) {
		responseStructure.setMessage("Manager updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, manager));
		return responseStructure;
	}

}
