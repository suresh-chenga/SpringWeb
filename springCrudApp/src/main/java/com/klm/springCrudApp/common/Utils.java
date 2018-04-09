package com.klm.springCrudApp.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.klm.springCrudApp.model.Employee;

public class Utils {
	
private static List<Employee> employees;
	
	static{
		employees= createDummyEmployees();
	}

	public static List<Employee> getAllEmployess() {		
		return employees;
	}
	
	public static Employee filterEmpDataWithEid(int eid){
		Employee employee = null;		
		if(null != employees){
			employee = new Employee();
			employee = employees.stream().filter(emp -> emp.getEid() == eid).findFirst().get();
		}			
		return employee;
	}

	public static List<Employee> filterEmpData(String name, String filterValue) {
		List<Employee> empList = new ArrayList<>();
		
		switch(name) {
			case "ename":
				empList = employees.stream().filter(emp -> emp.getEname().equalsIgnoreCase(filterValue)).collect(Collectors.toList());
				break;
			case "designation":
				empList = employees.stream().filter(emp -> emp.getDesignation().equalsIgnoreCase(filterValue)).collect(Collectors.toList());
				break;
			case "searchCriteria":
				empList = employees.stream().filter(emp -> emp.getEname().contains(filterValue)).collect(Collectors.toList());
				break;
			default:
				empList = null;
		}
		
		return empList;
	}
	
	private static List<Employee> createDummyEmployees(){
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(1,"Sam",70000,"ITA"));
		emps.add(new Employee(2,"Tom",50000,"AST"));
		emps.add(new Employee(3,"Jerome",30000,"SE"));
		emps.add(new Employee(4,"Silvia",40000,"SSE"));
		emps.add(new Employee(5,"Sam",60000,"SSE"));
		return emps;
	}
}
