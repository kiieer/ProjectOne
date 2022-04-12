package com.revature.project.one.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 
}
