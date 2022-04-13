package com.revature.project.one.service;

import java.util.List;

import com.revature.project.one.entities.Employee;
import com.revature.project.one.entities.Reimbursement;

public interface EmpSInterface {
	Employee login (Employee empObj);
	
	List<Employee> getAllEmployees();
	
	List<Reimbursement> getAllReimbursements();
	
	boolean createReimbursement(Reimbursement reimbursement);
}
