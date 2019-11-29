package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Reviewerdao;
import com.maren.model.Reviewer;

/**
 * Servlet implementation class ViewReviewer
 */
@WebServlet("/ViewReviewer")
public class ViewReviewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReviewer() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		out.println("<title>View Reviewer</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("view.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>View Reviewer</h1>");
		List<Reviewer> list=Reviewerdao.getAllReviewer();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Name</th><th>Id</th><th>Email</th><th>Contact</th><th></th>");
		for(Reviewer r:list){
			out.print("<tr><td>"+r.getName()+"</td><td>"+r.getId()+"</td><td>"+r.getEmail()+"</td><td>"+r.getContact()+"</td></tr>");
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
