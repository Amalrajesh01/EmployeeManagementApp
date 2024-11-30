package com.besant.packages.controller;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.SignupService;
import com.besant.packages.services.impl.SignupServiceImpl;

@WebServlet("/signup")
public class SignupController extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		SignupService service = new SignupServiceImpl();
		try {
			service.signUp(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
