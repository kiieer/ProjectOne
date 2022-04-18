package com.revature.project.one.daotests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.revature.project.one.dao.EmpDAO;
import com.revature.project.one.dao.EmpDAOPostgres;
import com.revature.project.one.entities.Employee;

public class EmpDAOTest {
	private static EmpDAO rdao = new EmpDAOPostgres();
	private static Employee globalEmp;
	
	
	@Test
	@Order(1)
	void loginTest() {
		Employee e1 = new Employee(5, "emp", "emp", "employee");
		EmpDAOTest.globalEmp = rdao.login(e1);
		Assertions.assertEquals(globalEmp.getId(), e1.getId());
	}
}
