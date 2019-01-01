package com.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		HttpSession session = request.getSession();
		
		if (userName.equals("admin") && password.equals("admin123")) {
			
			out.print("Welcome, " + userName);
			session.setAttribute("username", userName);
			response.sendRedirect("./ProfileServlet");
		} else {
			out.print("Sorry, username or password error!");
			response.sendRedirect("login.html");
		}
		out.close();
	}
}
