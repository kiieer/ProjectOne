package com.revature.project.one.handlers;

import com.revature.project.one.entities.Employee;
import com.revature.project.one.service.EmpSInterface;
import com.revature.project.one.service.EmpService;

import io.javalin.http.Handler;

public class EmployeeController {
	static EmpSInterface service = new EmpService(); 
	
	public static Handler login = ctx-> {
	Employee empObj = ctx.bodyAsClass(Employee.class);
	Employee login = service.login(empObj);
	System.out.println(login);
	ctx.sessionAttribute("currentUser", login);
	ctx.json(login);
	};
	
	public static Handler getallEmployees = ctx-> {
		
	};
	
	public static Handler getallReimbursements= ctx-> {
		
	};
	
	public static Handler createReimbursement = ctx-> {
			
	};
	
	public static Handler manageReimbursement = ctx-> {
		
	};
	
}
