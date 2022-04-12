package com.revature.project.one.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.netty.util.internal.SystemPropertyUtil;

public class ConnUtil {
	private static String url = System.getenv("PROJ_ONE");
	private static Connection conn;
	private static ConnUtil cu=new ConnUtil();
	
	private ConnUtil() {
		if(conn==null) {
			try {
				conn= DriverManager.getConnection(url);
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static Connection getInstance() {
		
		return conn;
		
	}
	
	
    }
