package com.revature.project.one.apps;

import com.revature.pctc.handlers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
public static void main(String[] args) {
	Javalin app = Javalin.create(ctx -> {ctx.enableCorsForAllOrigins(); ctx.addStaticFiles("web", Location.CLASSPATH);}).start();
	
	app.post("/login", EmployeeController.login);
}
}
