package com.src.sample.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.sample.dao.EmployeeDao;
import com.src.sample.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployess() {
		List<Employee> list = employeeDao.fetchEmployeeDetails();
		return list;
	}

	@Override
	public Employee getEmployeeDetailsByEId(int employeeId) throws Exception {		
		List<Employee> list = employeeDao.fetchEmployeeDetails();
		Predicate<Employee> listFilter = emp -> emp.getEmployeeId() == employeeId;
		return filterEmployeeData(list, listFilter).get(0);
	}

	@Override
	public List<Employee> getEmployeeDetailsByEName(String employeeName) throws Exception {
		List<Employee> list = employeeDao.fetchEmployeeDetails();
		Predicate<Employee> listFilter = emp -> emp.getEmployeeName().equalsIgnoreCase(employeeName);
		return filterEmployeeData(list, listFilter);
	}

	@Override
	public List<Employee> getEmployeeDetailsByDesignation(String designation) throws Exception {
		List<Employee> list = employeeDao.fetchEmployeeDetails();
		Predicate<Employee> listFilter = emp -> emp.getDesignation().equalsIgnoreCase(designation);
		return filterEmployeeData(list, listFilter);
	}

	@Override
	public List<Employee> employeeSearchCriteria(String value) throws Exception {
		List<Employee> list = employeeDao.fetchEmployeeDetails();
		Predicate<Employee> listFilter = emp -> emp.getEmployeeName().contains(value);
		return filterEmployeeData(list, listFilter);
	}
	
	private List<Employee> filterEmployeeData(List<Employee> list, Predicate<Employee> listFilter) throws Exception {
		list = list.stream().filter(listFilter).collect(Collectors.toList());
		if(null == list || list.isEmpty()) {
			throw new Exception("Data is not found");
		}
		return list;
	}

}
