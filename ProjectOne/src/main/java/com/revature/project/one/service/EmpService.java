package com.revature.project.one.service;

import java.util.List;

import com.revature.project.one.dao.EmpDAO;
import com.revature.project.one.dao.EmpDAOPostgres;
import com.revature.project.one.entities.Employee;
import com.revature.project.one.entities.Reimbursement;

public class EmpService implements EmpSInterface {
	static EmpDAO dao = new EmpDAOPostgres();
	@Override
	public Employee login(Employee empObj) {
		// TODO Auto-generated method stub
		return dao.login(empObj);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}
	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return dao.getAllReimbursements();
	}
	@Override
	public boolean createReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return dao.createReimbursement(reimbursement);
	}
}
