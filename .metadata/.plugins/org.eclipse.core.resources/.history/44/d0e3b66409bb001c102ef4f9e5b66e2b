package com.revature.project.one.apps;

import com.revature.project.one.handlers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
public static void main(String[] args) {
	Javalin app = Javalin.create(ctx -> {
		ctx.enableCorsForAllOrigins();
		ctx.addStaticFiles("web", Location.CLASSPATH);}
	).start();
	
	app.before(ctx -> ctx.header("Access-Control-Allow-Credentials", "true"));

	app.post("/login", EmployeeController.login);
	app.get("/fetchemps", EmployeeController.getAllEmployees);
}
}
