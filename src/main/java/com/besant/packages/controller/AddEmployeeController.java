package com.besant.packages.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.AddEmployeeService;
import com.besant.packages.services.impl.AddEmployeeServiceImpl;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		AddEmployeeService service = new AddEmployeeServiceImpl();
		service.addEmployeeData(req, resp);
	}
}
