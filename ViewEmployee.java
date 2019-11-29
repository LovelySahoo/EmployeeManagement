package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Saveemployee;
import com.maren.model.Employee;

/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Employee</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("view.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>View Employee</h1>");
		List<Employee> list=Saveemployee.getAllEmployees();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Empname</th><th>Empid</th><th>Email</th><th>Contact</th><th>Address</th>");
		for(Employee e:list){
			out.print("<tr><td>"+e.getEmpname()+"</td><td>"+e.getEmpid()+"</td><td>"+e.getEmail()+"</td><td>"+e.getContact()+"</td><td>"+e.getAddress()+"</td><td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
