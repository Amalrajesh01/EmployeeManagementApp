package com.besant.packages.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.AllEmployeeService;
import com.besant.packages.services.impl.AllEmployeeServiceImpl;
@WebServlet("/allEmployees")
public class AllEmployeeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AllEmployeeService service = new AllEmployeeServiceImpl();
		service.allEmployees(req, resp);
	}
	
	

}
