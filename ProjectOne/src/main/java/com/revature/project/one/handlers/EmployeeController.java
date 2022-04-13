package com.revature.project.one.handlers;

import java.util.List;

import com.revature.project.one.entities.Employee;
import com.revature.project.one.entities.Reimbursement;
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
	
	public static Handler getAllEmployees = ctx-> {
		List<Employee> eList = service.getAllEmployees();
		ctx.json(eList);
	};
	
	public static Handler getAllReimbursements= ctx-> {
		List<Reimbursement> rList = service.getAllReimbursements();
		ctx.json(rList);
	};
	
	public static Handler createReimbursement = ctx-> {
		Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
		if (service.createReimbursement(reimbursement)) {
			ctx.result("[SUCCESSFUL] Your reimbursement has been added!");
			ctx.status(201);
		} else {
			ctx.result("[ERROR] There is an internal error.");
			ctx.status(404);
		}
	};
	
	public static Handler manageReimbursement = ctx-> {
		
	};
	
}
