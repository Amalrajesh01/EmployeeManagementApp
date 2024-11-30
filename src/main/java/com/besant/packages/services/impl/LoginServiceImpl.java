package com.besant.packages.services.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.service.LoginService;
import com.besant.packages.utils.JdbcConnection;

public class LoginServiceImpl implements LoginService {

	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();

			String signUpQuery = "SELECT * FROM employeemanagement.authentication where email = ? and password= ?";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(signUpQuery);

			statement.setString(1, req.getParameter("email"));
			statement.setString(2, req.getParameter("password"));

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				HttpSession session = req.getSession();
				session.setAttribute("uid", resultSet.getInt("id"));
				res.sendRedirect("dashboard.html");
			} else {
				System.out.println("Login failed");
			}

			JdbcConnection.connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
