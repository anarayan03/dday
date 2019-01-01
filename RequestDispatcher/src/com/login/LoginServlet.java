package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

		String username = request.getParameter("userName").trim();
		String password = request.getParameter("userPass").trim();

		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		if (username.equals("admin") && password.equals("admin123")) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			//session.setMaxInactiveInterval(30);
			//response.sendRedirect("/WelcomeServlet");
			RequestDispatcher rd = request.getRequestDispatcher("/WelcomeServlet");
			rd.forward(request, response);
		}

		else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);

		}
	}
}
