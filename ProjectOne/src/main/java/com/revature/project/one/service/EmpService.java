package com.revature.project.one.service;

import com.revature.project.one.dao.EmpDAO;
import com.revature.project.one.dao.EmpDAOPostgres;
import com.revature.project.one.entities.Employee;

public class EmpService implements EmpSInterface {
	static EmpDAO dao = new EmpDAOPostgres();
	@Override
	public Employee login(Employee empObj) {
		// TODO Auto-generated method stub
		return dao.login(empObj);
	}
}
