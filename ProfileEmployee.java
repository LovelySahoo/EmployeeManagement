package com.maren.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Saveemployee;
import com.maren.model.Employee;

/**
 * Servlet implementation class ProfileEmployee
 */
@WebServlet("/ProfileEmployee")
public class ProfileEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = (String)request.getSession().getAttribute("name");
		RequestDispatcher rd = null;
		if(name == null) {
			rd = request.getRequestDispatcher("login.html");
			request.setAttribute("error", "Unauthorised User");
		}else {
			Saveemployee employeedao = new Saveemployee();
			Employee employee = employeedao.getProfileByname(name);
			request.getSession().setAttribute("employee", employee);
			rd = request.getRequestDispatcher("Employee.jsp");
		
			
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
