package com.revature.project.one.handlers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.project.one.apps.Main;
import com.revature.project.one.entities.Employee;
import com.revature.project.one.entities.Reimbursement;
import com.revature.project.one.service.EmpSInterface;
import com.revature.project.one.service.EmpService;
import com.revature.project.one.service.RemSInterface;
import com.revature.project.one.service.RemService;

import io.javalin.http.Handler;

public class EmployeeController {
	private static final Logger logger = LogManager.getLogger(Main.class);
	static EmpSInterface eservice = new EmpService(); 
	static RemSInterface rservice = new RemService(); 
	
	public static Handler login = ctx-> {
	Employee empObj = ctx.bodyAsClass(Employee.class);
	Employee login = eservice.login(empObj);
	logger.debug("User logged in: " + login);
	ctx.sessionAttribute("CUID", login.getId());
	int CUID = ctx.sessionAttribute("CUID");
	logger.debug("JSA: " + CUID);
	ctx.json(login);
	logger.info("EmployeeController.java Handler Login executed successfully.");
	};
	
	public static Handler getAllEmployees = ctx-> {
		List<Employee> eList = eservice.getAllEmployees();
		ctx.json(eList);
		logger.info("EmployeeController.java Handler GetAllEmployees executed successfully.");
	};
	
	public static Handler getEmployeeById = ctx-> {
		int p = Integer.parseInt(ctx.pathParam("id"));
		List<Employee> eList = eservice.getEmployeeById(p);
		if(eList.size() == 0) {
			ctx.result("[ERROR] We're sorry, the client you have specified does not exist in our database. Try again.");
			ctx.status(404);
			logger.error("EmployeeController.java Handler getEmployeeByID failed.");
			
		} else {
			ctx.json(eList);
			ctx.status(200);
			logger.info("EmployeeController.java Handler getEmployeeByID executed successfully.");
		}
	};
	
	public static Handler getAllReimbursements= ctx-> {
		List<Reimbursement> rList = rservice.getAllReimbursements();
		ctx.json(rList);
		logger.info("EmployeeController.java Handler getAllReimbursements executed successfully.");
	};
	
	public static Handler createReimbursement = ctx-> {
		int CUID = ctx.sessionAttribute("CUID");
		 System.out.println(CUID);
		// String reqBody=ctx.body();
		Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
		if (rservice.createReimbursement(reimbursement, CUID)) {
			ctx.result("[SUCCESSFUL] Your reimbursement has been added!");
			ctx.status(201);
			logger.info("EmployeeController.java Handler createReimbursement executed successfully.");
		} else {
			ctx.result("[ERROR] There is an internal error.");
			ctx.status(404);
			logger.error("EmployeeController.java Handler createReimbursement failed.");
		}
	};
	
	public static Handler getReimbursementById = ctx-> {
		int p = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursement> rList = rservice.getReimbursementById(p);
		if(rList.size() == 0) {
			ctx.result("[ERROR] We're sorry, the client you have specified does not exist in our database. Try again.");
			ctx.status(404);
			logger.error("EmployeeController.java Handler getReimbursementById failed.");
			
		} else {
			ctx.json(rList);
			ctx.status(200);
			logger.info("EmployeeController.java Handler getReimbursementById executed successfully.");
		}
	};
	
	public static Handler resolveReimbursement = ctx-> {
		int CUID = ctx.sessionAttribute("CUID");
		System.out.println(CUID);
		Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
		List <Reimbursement> rList = rservice.getReimbursementById(reimbursement.getId());
		if (rList.size() == 0) {
			ctx.status(404);
			ctx.result("[ERROR] We're sorry, the reimbursement you have specified does not exist in our database. Try again.");
			logger.error("EmployeeController.java Handler resolveReimbursement failed.");
		} else {
			rservice.resolveReimbursement(reimbursement, CUID);
			ctx.status(200);
			ctx.result("[SUCCESS] The reimbursement has been successfully updated.");
			logger.info("EmployeeController.java Handler resolveReimbursement executed successfully.");
		}
	};
	
	public static Handler getReimbursementsByEmployee = ctx-> {
		int p = ctx.sessionAttribute("CUID");
		List<Employee> rList = eservice.getEmployeeById(p);
		if(rList.size() == 0) {
			ctx.result("[ERROR] We're sorry, the reimbursement you have specified does not exist in our database. Try again.");
			ctx.status(404);
			logger.error("EmployeeController.java Handler getReimbursementsByEmployee failed.");
			
		} else {
			List<Reimbursement> reList = rservice.getReimbursementsByEmployee(p);
			ctx.json(reList);
			ctx.status(200);
			logger.info("EmployeeController.java Handler getReimbursementsByEmployee executed successfully.");
		}
	};
	
}
