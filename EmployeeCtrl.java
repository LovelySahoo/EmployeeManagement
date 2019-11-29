package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Saveemployee;
import com.maren.model.Employee;

/**
 * Servlet implementation class EmployeeCtrl
 */
@WebServlet("/EmployeeCtrl")
public class EmployeeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
	        response.setContentType("text/jsp");  
	        PrintWriter out=response.getWriter();  
	          
	        String empname=request.getParameter("empname");  
	        String empid=request.getParameter("empid");
	        String email=request.getParameter("email");
	        String contact=request.getParameter("contact");
	        String address=request.getParameter("address");
	       
	       Employee e=new Employee();  
	        e.setEmpname(empname);  
	        e.setEmpid(empid);   
	        e.setEmail(email);
	        e.setContact(contact);
	        e.setAddress(address);
	        
	        
	          
	        int status=Saveemployee.save(e);  
	        if(status>0){  
	            out.print("Record saved successfully!");  
	         //   request.getRequestDispatcher("adminnav.jsp");  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	}

}
