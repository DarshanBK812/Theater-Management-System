package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int employeeId) {

		Optional<Employee> employee = employeeRepo.findById(employeeId);
		if(employee.isEmpty()) {
			return null;
		} else {
			return employee.get();
		}
	}

	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee deleteEmployeeById(int empId) {
		Employee employee = employeeRepo.findById(empId).get();
		employeeRepo.delete(employee);
		return employee;
	}

	public Employee updateEmployeeById(int oleEmpId, Employee newEmployee) {
		newEmployee.setEmployeeId(oleEmpId);
		employeeRepo.save(newEmployee);
		return newEmployee;

	}

}
