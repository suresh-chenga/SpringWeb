package com.src.sample.dao;

import java.util.List;

import com.src.sample.model.Employee;

public interface EmployeeDao {
	
	List<Employee> fetchEmployeeDetails();

}
