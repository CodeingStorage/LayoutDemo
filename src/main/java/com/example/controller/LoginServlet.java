package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
		
		// 預設用戶：username=user,password=123($2a$10$qgVZMdNoKQ/JwXr4eQS8SOu2cYBPE9Y.ox2QRX9y.wjIKQZ7S3OBe=)
		boolean isPasswordMatch = BCrypt.checkpw(password, "$2a$10$qgVZMdNoKQ/JwXr4eQS8SOu2cYBPE9Y.ox2QRX9y.wjIKQZ7S3OBe=");
		if("user".equals(username) && isPasswordMatch) {
			resp.sendRedirect("./");
			return;
		}
		
		// 處理驗證沒有過的時候，要怎麼處理
		
	}

}
