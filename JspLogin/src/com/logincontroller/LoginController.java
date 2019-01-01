package com.logincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
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
		String un = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		if (un.equals("admin") && pwd.equals("admin123")) {
			out.print("Welcome, " + un);
			HttpSession session = request.getSession(true);

			session.setAttribute("user", un);
			session.setMaxInactiveInterval(30); // 30 seconds
			response.sendRedirect("home.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
