package com.besant.packages.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.DeleteEmployeeService;
import com.besant.packages.services.impl.DeleteEmployeeServiceImpl;

@WebServlet("/deleteEmployeeData")
public class DeleteEmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		DeleteEmployeeService service = new DeleteEmployeeServiceImpl();
		service.deleteEmployeeData(req, resp);
	}
}
