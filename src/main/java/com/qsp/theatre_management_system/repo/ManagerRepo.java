package com.qsp.theatre_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.theatre_management_system.dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
