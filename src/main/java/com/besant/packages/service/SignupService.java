package com.besant.packages.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SignupService {

	public void signUp(HttpServletRequest req, HttpServletResponse res) throws SQLException;

}
