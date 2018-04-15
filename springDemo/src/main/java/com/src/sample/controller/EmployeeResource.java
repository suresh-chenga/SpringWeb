package com.src.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.src.sample.model.Employee;
import com.src.sample.service.EmployeeService;

/**
 * This class is used to fetch, create and update the employee details
 * 
 * @author Suresh
 *
 */
@RestController
@RequestMapping("employee")
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/EmployeeDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		// Service call to get all employee details
		List<Employee> empList = employeeService.getAllEmployess();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK); 
	}
	
	/**
	 * Method is used to get employee{@link Employee} detail by eid
	 * 
	 * @return Employee
	 * @throws Exception 
	 */
	@RequestMapping(value="/EmployeeDetailByID/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailById(@PathVariable("employeeId") int employeeId) throws Exception{
		// Service call to get employee detail by employeeId
		Employee emp = employeeService.getEmployeeDetailsByEId(employeeId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by employeeName
	 * 
	 * @return List<Employee>
	 * @throws Exception 
	 */
	@RequestMapping(value="/EmployeeDetailByName/{employeeName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDetailByName(@PathVariable("employeeName") String employeeName) throws Exception {

		// Service call to get employee detail by employeeName
		List<Employee> empList = employeeService.getEmployeeDetailsByEName(employeeName);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by designation
	 * 
	 * @return List<Employee>
	 * @throws Exception 
	 */
	@RequestMapping(value="/EmployeeDetailByDesignation/{designation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDetailByDesignation(@PathVariable("designation") String designation) throws Exception {

		// Service call to get employee detail by designation
		List<Employee> empList = employeeService.getEmployeeDetailsByDesignation(designation);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by employeeName
	 * 
	 * @return List<Employee>
	 * @throws Exception 
	 */
	@RequestMapping(value="/EmployeeSearch/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDeatilsBySearchCriteria(@PathVariable("value") String value) throws Exception {

		// Service call to get employee detail by search value
		List<Employee> empList = employeeService.employeeSearchCriteria(value);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

}
