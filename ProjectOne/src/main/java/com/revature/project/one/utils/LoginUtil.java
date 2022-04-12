package com.revature.project.one.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginUtil {
    public static Connection createConnection() {
        String url = System.getenv("PROJ_ONE");
        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
