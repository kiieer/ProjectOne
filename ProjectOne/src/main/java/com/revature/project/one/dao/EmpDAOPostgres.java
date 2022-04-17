package com.revature.project.one.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.project.one.apps.Main;
import com.revature.project.one.entities.Employee;
import com.revature.project.one.utils.ConnUtil;

public class EmpDAOPostgres implements EmpDAO {
	private static final Logger logger = LogManager.getLogger(Main.class);
	static Connection conn = ConnUtil.getInstance();
	
	@Override
	public Employee login(Employee empObj) {
		// TODO Auto-generated method stub
		Employee localEmp = new Employee();
		try {
			PreparedStatement ptsmt = conn.prepareStatement("select * from employees");
			ResultSet rs = ptsmt.executeQuery();
			String eusername = empObj.getUsername();
			String epass = empObj.getPass();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("pass");
				String username = rs.getString("username");
				String type = rs.getString("emptype");
				if (eusername.equals(username) && epass.equals(password)) {
					localEmp.setId(id);
					localEmp.setUsername(eusername);
					localEmp.setPass(epass);
					localEmp.setType(type);
					logger.info("EmpDAOPostgres.java method Login executed successfully.");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("EmpDAOPostgres.java method Login failed.");
		}
		return localEmp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String selectEmps = "select * from employees";
		ArrayList<Employee> eList = new ArrayList<Employee>();
		Employee e;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(selectEmps);
			ResultSet rs = ptsmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("pass");
				String username = rs.getString("username");
				String type = rs.getString("emptype");
				e = new Employee(id, username, password, type);
				eList.add(e);
				
			}
			logger.info("EmpDAOPostgres.java method getAllEmployees executed successfully.");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error("EmpDAOPostgres.java getAllEmployees failed.");
		}
		
		return eList;
	} 
	
	@Override
	public List<Employee> getEmployeeById(int p) {
		// TODO Auto-generated method stub
		String selectEmps = "select * from employees where id=?";
		ArrayList<Employee> eList = new ArrayList<Employee>();
		Employee e;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(selectEmps);
			ptsmt.setInt(1, p);
			ResultSet rs = ptsmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("pass");
				String username = rs.getString("username");
				String type = rs.getString("emptype");
				e = new Employee(id, username, password, type);
				eList.add(e);
			}
			logger.info("EmpDAOPostgres.java method getEmployeeById executed successfully.");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error("EmpDAOPostgres.java getEmployeeById failed.");
		}
		
		return eList;
	}
}
