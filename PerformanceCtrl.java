package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Performancedao;
import com.maren.model.Performance;

/**
 * Servlet implementation class PerformanceCtrl
 */
@WebServlet("/PerformanceCtrl")
public class PerformanceCtrl extends HttpServlet {
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
		//doGet(request, response);
		response.setContentType("text/jsp");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String department=request.getParameter("department");
        String attendence=request.getParameter("attendence");
        String status=request.getParameter("status");
        //String department=request.getParameter("department");
        
       
     Performance p=new Performance();  
        p.setName(name);  
        p.setDepartment(department);   
        p.setAttendence(attendence);
        p.setStatus(status);
       // s.setDepartment(department);
        
        int status1=Performancedao.save(p);  
        if(status1>0){  
            out.print("Performance report is saved successfully!");  
           // request.getRequestDispatcher("adminnav.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save report");  
        }  
          
        out.close();  
        }
	}


