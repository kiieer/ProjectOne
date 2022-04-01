package com.revature.project.one.apps;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
public static void main(String[] args) {
		
	Javalin app = Javalin.create(
			ctx -> {
				ctx.addStaticFiles("web", Location.CLASSPATH);}
			).start();
}
}
