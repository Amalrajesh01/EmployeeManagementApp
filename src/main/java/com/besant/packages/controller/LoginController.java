package com.besant.packages.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.packages.service.LoginService;
import com.besant.packages.services.impl.LoginServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		LoginService service = new LoginServiceImpl();
		service.login(req, res);
	}
}
