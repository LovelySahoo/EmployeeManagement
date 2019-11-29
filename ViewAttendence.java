package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Attendencedao;
import com.maren.model.Attendence;

/**
 * Servlet implementation class ViewAttendence
 */
@WebServlet("/ViewAttendence")
public class ViewAttendence extends HttpServlet {
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
		out.println("<title>View Attendence</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("view.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>Attendence Table</h1>");
		List<Attendence> list=Attendencedao.getAttendencetable();
		out.println("<table class='table table-bordered table-striped'>");                               
		out.print("<tr><th>Name</th>&nbsp&nbsp&nbsp&nbsp<th>Department</th>&nbsp&nbsp&nbsp&nbsp<th>Status</th>&nbsp&nbsp&nbsp&nbsp<th>Date</th></tr>");
		for(Attendence a:list){
			out.print("<tr><td>"+a.getName()+"</td>&nbsp&nbsp&nbsp&nbsp<td>"+a.getDepartment()+"</td>&nbsp&nbsp&nbsp&nbsp<td>"+a.getStatus()+"</td>&nbsp&nbsp&nbsp&nbsp<td>"+a.getDate()+"</td></tr>");
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
