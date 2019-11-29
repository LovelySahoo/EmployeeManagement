package com.maren.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.dao.Reviewerdao;
import com.maren.model.Reviewer;

/**
 * Servlet implementation class ReviewerCtrl
 */
@WebServlet("/ReviewerCtrl")
public class ReviewerCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String id=request.getParameter("id");
        String email=request.getParameter("email");
        String contact=request.getParameter("contact");
        
       
       Reviewer r=new Reviewer();  
        r.setName(name);  
        r.setId(id);   
        r.setEmail(email);
        r.setContact(contact);
        
        int status=Reviewerdao.save(r);  
        if(status>0){  
            out.print("Record saved successfully!");  
           // request.getRequestDispatcher("adminnav.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
        }
	}


