package com.profileServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
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

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("username");

			out.print("Hello, " + name + " Welcome to Profile");
		} else {
			out.print("Please login first");
			response.sendRedirect("login.html");
		}
		out.print("<a href='index.html'>Index</a>");
	}

}
