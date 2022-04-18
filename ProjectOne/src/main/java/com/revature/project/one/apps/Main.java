package com.revature.project.one.apps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.project.one.handlers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
public static void main(String[] args) {
	Javalin app = Javalin.create(ctx -> {
		ctx.enableCorsForAllOrigins();
		ctx.addStaticFiles("web", Location.CLASSPATH);}
	).start();
	
	
	/* Thank you for taking the time to check me out!
	 * This is my Project One, affectionately named Solana. 
	 * Solana is not real, it is a false company I developed for the 
	 * purpose of design. It was made utilizing all of the tools our 
	 * batch has learned over the past couple of amazing weeks with Revature.
	 * Have a good one,
	 * Kiersten Christlieb
	 */
	
	app.before(ctx -> ctx.header("Access-Control-Allow-Credentials", "true"));

	app.post("/login", EmployeeController.login);
	app.get("/fetchemps", EmployeeController.getAllEmployees);
	app.get("/fetchemps/{id}", EmployeeController.getEmployeeById);
	app.get("/fetchreim", EmployeeController.getAllReimbursements);
	app.get("/fetchreim/emp/", EmployeeController.getReimbursementsByEmployee);
	app.post("/makereim", EmployeeController.createReimbursement);
	app.get("/fetchreim/{id}", EmployeeController.getReimbursementById);
	app.put("/resolve", EmployeeController.resolveReimbursement);
	
	 logger.info("Solana has hosted successfully using Javalin.");
}
}
