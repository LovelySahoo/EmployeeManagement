package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Taskdao;
import com.maren.model.Task;

/**
 * Servlet implementation class TaskCtrl
 */
@WebServlet("/TaskCtrl")
public class TaskCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
        String title=request.getParameter("title");
        String lastdate=request.getParameter("lastdate");
        
        Task t=new Task();  
        t.setEmpname(empname);  
        t.setEmpid(empid);   
        t.setTitle(title);
        t.setLastdate(lastdate);
        
        int status=Taskdao.assign(t);  
        if(status>0){  
            out.print("Project assigned successfully!");  
           // request.getRequestDispatcher("adminnav.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to assign record");  
        }  
          
        out.close();  
        }
	}


