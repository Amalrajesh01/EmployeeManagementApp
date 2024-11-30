package com.besant.packages.services.impl;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.service.AddEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class AddEmployeeServiceImpl implements AddEmployeeService {

	@Override
	public void addEmployeeData(HttpServletRequest req, HttpServletResponse res) {

		try {
			JdbcConnection.jdbcConnect();
			String addEmployeeDataQuery = "insert into employeeManagement.employeeData(  empId, empName, empEmail, empSalary,empAddress,empDesignation, empDepartment,empPhoneNumber, creatorId)  value ( ?, ? ,?, ? ,?, ? ,?, ? ,? )";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(addEmployeeDataQuery);

			statement.setString(1, req.getParameter("empId"));
			statement.setString(2, req.getParameter("empName"));
			statement.setString(3, req.getParameter("empEmail"));
			statement.setString(4, req.getParameter("empSalary"));
			statement.setString(5, req.getParameter("empAddress"));
			statement.setString(6, req.getParameter("empDesignation"));
			statement.setString(7, req.getParameter("empDepartment"));
			statement.setString(8, req.getParameter("empPhoneNumber"));

			HttpSession session = req.getSession();
			System.out.println("creator id : " + (int) session.getAttribute("uid"));
			statement.setInt(9, (int) session.getAttribute("uid"));
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("dashboard.html");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
