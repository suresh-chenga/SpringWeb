package com.src.sample.service;

import java.util.List;

import com.src.sample.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployess();
	Employee getEmployeeDetailsByEId(int employeeId) throws Exception;	
	List<Employee> getEmployeeDetailsByEName(String employeeName) throws Exception;
	List<Employee> getEmployeeDetailsByDesignation(String designation) throws Exception;
	List<Employee> employeeSearchCriteria(String value) throws Exception;
}
