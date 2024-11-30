package com.besant.packages.services.impl;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.DeleteEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class DeleteEmployeeServiceImpl implements DeleteEmployeeService {

	@Override
	public void deleteEmployeeData(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();
			String signUpQuery =  "delete from employeeManagement.employeedata where id =?";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(signUpQuery);

			statement.setInt(1, Integer.parseInt(req.getParameter("id")));

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("/EmployeeManagementApp/allEmployees");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
