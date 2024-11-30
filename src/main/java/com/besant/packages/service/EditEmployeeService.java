package com.besant.packages.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EditEmployeeService {
	public void editEmployeeData(HttpServletRequest req, HttpServletResponse res);
	public void updateEmployeeData(HttpServletRequest req, HttpServletResponse res);
}
