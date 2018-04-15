package com.src.sample.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.src.sample.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static List<Employee> employees;
	
	static{
		employees= createDummyEmployees();
	}

	@Override
	public List<Employee> fetchEmployeeDetails() {
		return employees;
	}
	
	private static List<Employee> createDummyEmployees(){
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(1,"Sam","ITA", 70000));
		emps.add(new Employee(2,"Tom","AST",50000));
		emps.add(new Employee(3,"Jerome","SE",30000));
		emps.add(new Employee(4,"Silvia","SSE",40000));
		emps.add(new Employee(5,"Sam","SSE",60000));
		return emps;
	}

}
