package com.besant.packages.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.EditEmployeeService;
import com.besant.packages.services.impl.EditEmployeeServiceImpl;

@WebServlet("/updateEmployee")
public class UpdateEmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		EditEmployeeService service = new EditEmployeeServiceImpl();
		service.updateEmployeeData(req, resp);
	}
}
