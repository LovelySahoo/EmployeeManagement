package com.maren.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.model.Admin;
import com.maren.services.AdminServices;


/**
 * Servlet implementation class ProfileAdmin
 */
@WebServlet("/ProfileController")
public class ProfileAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getSession().getAttribute("name");
		RequestDispatcher rd = null;
		if(name == null) {
			rd = request.getRequestDispatcher("login.html");
			request.setAttribute("error", "Unauthorised User");
		}else {
			AdminServices adminservices = new AdminServices();
			Admin admin = adminservices.getadmin(name);
			request.getSession().setAttribute("admin", admin);
			rd = request.getRequestDispatcher("Admin.jsp");
		
			
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
