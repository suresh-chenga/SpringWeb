package com.klm.springCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klm.springCrudApp.common.Utils;
import com.klm.springCrudApp.model.Employee;

/**
 * 
 * @author Suresh Chenga
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	public List<Employee> getAllEmployess() {		
		return Utils.getAllEmployess();
	}
	
	public Employee getByEId(int eid) {		
		return Utils.filterEmpDataWithEid(eid);
	}

	public List<Employee> getByEName(String ename) {		
		return Utils.filterEmpData("ename", ename);
	}
	
	public List<Employee> getByDesignation(String desc) {
		return Utils.filterEmpData("designation", desc);
	}
	
	public List<Employee> empSearchCriteria(String value) {
		return Utils.filterEmpData("searchCriteria", value);
	}	

}
