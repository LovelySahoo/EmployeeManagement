package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Attendencedao;
import com.maren.model.Attendence;

/**
 * Servlet implementation class AttendenceCtrl
 */
@WebServlet("/AttendenceCtrl")
public class AttendenceCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/jsp");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String department=request.getParameter("department");
        String status=request.getParameter("status");
        String date=request.getParameter("date");
        
        Attendence a=new Attendence();  
        a.setName(name);  
        a.setDepartment(department);   
        a.setStatus(status);
        a.setDate(date);
        
        int check =Attendencedao.assign(a);  
        if(check>0){  
            out.print("Attendence assigned successfully!");  
           // request.getRequestDispatcher("adminnav.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to assign attendence");  
        }  
          
        out.close();  
        }
	}


