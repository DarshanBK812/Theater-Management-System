package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Manager;
import com.qsp.theatre_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		Optional<Manager> manager = managerRepo.findById(managerId);
		if(manager.isEmpty()) {
			return null;
		}
		return manager.get();
	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = managerRepo.findById(managerId).get();
		managerRepo.delete(manager);
		return manager;
	}

	public Manager updateManagerById(int oldManagerId, Manager manager) {
		manager.setManagerId(oldManagerId);
		managerRepo.save(manager);
		return manager;
	}

}
