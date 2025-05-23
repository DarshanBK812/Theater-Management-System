package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.service.EmployeeService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}

	@GetMapping("/fetchAllEmployee")
	public ResponseStructureForAll<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}

	@DeleteMapping("/deleteEmployeeById")
	public ResponseStructure<Employee> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@PutMapping("/updateEmployeeById")
	public ResponseStructure<Employee> updateEmployeeById(@RequestParam int oldEmpId,
			@RequestBody Employee newEmployee) {
		return employeeService.updateEmployeeById(oldEmpId, newEmployee);
	}

}
