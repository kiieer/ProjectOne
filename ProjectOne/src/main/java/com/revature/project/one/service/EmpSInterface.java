package com.revature.project.one.service;

import java.util.List;

import com.revature.project.one.entities.Employee;

public interface EmpSInterface {
	
	Employee login (Employee empObj);
	
	List<Employee> getAllEmployees();
	
	List<Employee> getEmployeeById(int p);
}
