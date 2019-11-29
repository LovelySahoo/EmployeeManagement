package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Supervisordao;
import com.maren.model.Supervisor;

/**
 * Servlet implementation class ViewSupervisor
 */
@WebServlet("/ViewSupervisor")
public class ViewSupervisor extends HttpServlet {
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
		out.println("<title>View Supervisor</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("view.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>View Supervisor</h1>");
		List<Supervisor> list=Supervisordao.getAllSupervisor();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Empname</th><th>Empid</th><th>Email</th><th>Contact</th><th>Address</th>");
		for(Supervisor s:list){
			out.print("<tr><td>"+s.getName()+"</td><td>"+s.getId()+"</td><td>"+s.getEmail()+"</td><td>"+s.getContact()+"</td><td>"+s.getDepartment()+"</td><td></tr>");
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
