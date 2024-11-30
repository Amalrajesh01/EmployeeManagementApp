package com.besant.packages.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.EditEmployeeService;
import com.besant.packages.services.impl.EditEmployeeServiceImpl;

@WebServlet("/editEmployeeData")
public class EditEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EditEmployeeService service = new EditEmployeeServiceImpl();
		service.editEmployeeData(req, resp);
	}
}
