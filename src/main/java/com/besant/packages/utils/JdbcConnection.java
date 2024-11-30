package com.besant.packages.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	public static Connection connection;
	
	public static  void jdbcConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root",
				"root");

	}
}
