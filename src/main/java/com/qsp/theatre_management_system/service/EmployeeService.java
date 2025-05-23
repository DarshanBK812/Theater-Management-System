
package com.qsp.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.EmployeeDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.exception.EmployeeNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Employee> responseStructureForAll;

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		responseStructure.setMessage("Employees saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;
	}

	public ResponseStructure<Employee> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if(employee != null) {
			responseStructure.setMessage("Employees fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return responseStructure;
		} else {
			throw new EmployeeNotFound();
		}
	}

	public ResponseStructureForAll<Employee> fetchAllEmployee() {
		responseStructureForAll.setMessage("All the Employees fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(employeeDao.fetchAllEmployee());
		return responseStructureForAll;
	}

	public ResponseStructure<Employee> deleteEmployeeById(int employeeId) {
		responseStructure.setMessage("Employees deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
		return responseStructure;
	}

	public ResponseStructure<Employee> updateEmployeeById(int oleEmpId, Employee newEmployee) {
		responseStructure.setMessage("Employees updated successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.updateEmployeeById(oleEmpId, newEmployee));
		return responseStructure;
	}

}
