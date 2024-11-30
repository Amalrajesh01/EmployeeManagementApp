package com.besant.packages.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.SignupService;
import com.besant.packages.utils.JdbcConnection;

public class SignupServiceImpl implements SignupService {

	@Override
	public void signUp(HttpServletRequest req, HttpServletResponse res) throws SQLException {

		try {
			JdbcConnection.jdbcConnect();
			String signUpQuery = "insert into employeeManagement.authentication(email, password) value (? ,?)";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(signUpQuery);
			
			statement.setString(1, req.getParameter("email"));
			statement.setString(2, req.getParameter("password"));

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("login.html");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {

			e.printStackTrace();
		} 

	}

}
