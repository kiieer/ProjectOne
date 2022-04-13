package com.revature.project.one.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.one.entities.Employee;
import com.revature.project.one.utils.ConnUtil;

public class EmpDAOPostgres implements EmpDAO {
	
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
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return eList;
	}
	 
}