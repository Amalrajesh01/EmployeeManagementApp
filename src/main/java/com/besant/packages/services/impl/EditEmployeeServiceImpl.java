package com.besant.packages.services.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.model.Employee;
import com.besant.packages.service.EditEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class EditEmployeeServiceImpl implements EditEmployeeService {

	@Override
	public void editEmployeeData(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();

			String selectQuery = "SELECT * FROM employeemanagement.employeedata where id = ? ";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(selectQuery);

			statement.setInt(1, Integer.parseInt(req.getParameter("id")));

			ResultSet resultSet = statement.executeQuery();

			List<Employee> employeeList = new ArrayList<>();
			while (resultSet.next()) {

				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setEmpName(resultSet.getString("empName"));
				employee.setEmail(resultSet.getString("empEmail"));
				employee.setEmpSalary(resultSet.getInt("empSalary"));
				employee.setEmpAddress(resultSet.getString("empAddress"));
				employee.setEmpDesignation(resultSet.getString("empDesignation"));
				employee.setEmpDepartment(resultSet.getString("empDepartment"));
				employee.setEmpPhoneNumber(resultSet.getInt("empPhoneNumber"));
				employee.setCreatorId(resultSet.getInt("creatorId"));
				employee.setCreatedAt(resultSet.getString("created_at"));
				employeeList.add(employee);
			}
			JdbcConnection.connection.close();

			req.setAttribute("employees", employeeList);
			req.getRequestDispatcher("editEmployee.jsp").forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployeeData(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();
			String addEmployeeDataQuery = "UPDATE employeeManagement.employeedata SET empName = ?,empEmail = ?, empSalary=?,  empAddress= ? ,empDesignation=?, empDepartment=?,empPhoneNumber=? WHERE id = ?;";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(addEmployeeDataQuery);
			statement.setString(1, req.getParameter("empName"));
			statement.setString(2, req.getParameter("empEmail"));
			statement.setString(3, req.getParameter("empSalary"));
			statement.setString(4, req.getParameter("empAddress"));
			statement.setString(5, req.getParameter("empDesignation"));
			statement.setString(6, req.getParameter("empDepartment"));
			statement.setString(7, req.getParameter("empPhoneNumber"));
			System.out.println(Integer.parseInt(req.getParameter("id")));
			statement.setInt(8, Integer.parseInt(req.getParameter("id")));
			
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
