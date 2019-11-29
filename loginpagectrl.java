package com.maren.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Reviewerdao;
import com.maren.dao.Saveemployee;
import com.maren.dao.Supervisordao;
import com.maren.services.AdminServices;
import com.maren.services.loginservices;

/**
 * Servlet implementation class loginpagectrl
 */
@WebServlet("/loginpagectrl")
public class loginpagectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		// check valid user and which type of user 
		loginservices loginservices=new loginservices();
		boolean flag = loginservices.loginuser(name, password,usertype);
		
		RequestDispatcher rd = null;
		if(flag) {
			if(usertype.equals("admin"))
			{
				//response.sendRedirect("adminnav.jsp");
				AdminServices admin=new AdminServices();
			    boolean flag1=admin.checkAdmin(name);
			    if(flag1) {
			    	
					rd = request.getRequestDispatcher("/ProfileController");
					request.getSession().setAttribute("name", name);
				}else {
					rd = request.getRequestDispatcher("login.html");
					request.setAttribute("error", "Username incorrect");
				}rd.forward(request, response);
			   }
			else if(usertype.equals("employee"))
			{
			//response.sendRedirect("employee.html");
			Saveemployee employee=new Saveemployee();
			    boolean flag1=employee.checkEmployee(name);
			    if(flag1) {
			    	rd = request.getRequestDispatcher("/ProfileEmployee");
					request.getSession().setAttribute("name", name);
					}else {
					rd = request.getRequestDispatcher("login.html");
					request.setAttribute("error", "Username incorrect");
				}rd.forward(request, response);
			}
			else if(usertype.equals("supervisor"))
			{
			//response.sendRedirect("supervisor.html");
				Supervisordao supervisor=new Supervisordao();
			    boolean flag1=supervisor.checkSupervisor(name);
			    if(flag1) {
			    	
					rd = request.getRequestDispatcher("/ProfileSupervisor");
					request.getSession().setAttribute("name", name);
				}else {
					rd = request.getRequestDispatcher("login.html");
					request.setAttribute("error", "Username incorrect");
				}rd.forward(request, response);
			}
			else if(usertype.equals("reviewer"))
			{
			
			//response.sendRedirect("Reviewer.jsp");
	Reviewerdao reviewer=new Reviewerdao();
		    boolean flag1=reviewer.checkReviewer(name);
	    if(flag1) {
		    	
				rd = request.getRequestDispatcher("/ProfileReviewer");
				request.getSession().setAttribute("name", name);
		}else {
				rd = request.getRequestDispatcher("login.html");
				request.setAttribute("error", "Username incorrect");
			}rd.forward(request, response);
			}	

		
		else if(usertype.equals("management"))
		{
			
		//	response.sendRedirect("view1.html");
	rd = request.getRequestDispatcher("/ViewPerformance");
			rd.forward(request, response);
		}
		}
		else
		{
		response.sendRedirect("login.html");
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
