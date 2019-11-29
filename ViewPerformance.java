package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Performancedao;
import com.maren.model.Performance;

/**
 * Servlet implementation class ViewPerformance
 */
@WebServlet("/ViewPerformance")
public class ViewPerformance extends HttpServlet {
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
		out.println("<title>View Reports</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body><center>");
		request.getRequestDispatcher("view1.html").include(request, response);
		out.println("<div class='container'>");
		out.print("<center><h1>MANAGEMENT DASHBOARD</h1></center>");
		out.print("<br><br>");
		out.print("<h2>PERFORMANCE REPORT</h2>");
		List<Performance> list=Performancedao.getPerformanceaReports();
		out.println("<table class='table table-bordered table-striped'>");	
		out.print("<tr><th>Name</th><th>Department</th><th>Attendence</th><th>Status</th></tr>");
		for(Performance p:list){
			out.print("<tr><td>"+p.getName()+"</td><td>"+p.getDepartment()+"</td><td>"+p.getAttendence()+"</td><td>"+p.getStatus()+"</td></tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		out.println("</center></body>");
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
