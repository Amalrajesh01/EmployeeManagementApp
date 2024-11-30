package com.besant.packages.services.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.packages.model.Employee;
import com.besant.packages.service.AllEmployeeService;
import com.besant.packages.utils.JdbcConnection;

public class AllEmployeeServiceImpl implements AllEmployeeService {

	@Override
	public void allEmployees(HttpServletRequest req, HttpServletResponse res) {
		try {
			JdbcConnection.jdbcConnect();

			String selectQuery = "SELECT * FROM employeemanagement.employeedata";
			PreparedStatement statement = JdbcConnection.connection.prepareStatement(selectQuery);
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
			for(Employee i : employeeList) {
				System.out.println(i.getEmpName());
			}
			
			
			
			JdbcConnection.connection.close();
			req.setAttribute("employees", employeeList);
			req.getRequestDispatcher("allEmployee.jsp").forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
