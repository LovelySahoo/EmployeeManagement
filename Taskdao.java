package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.maren.model.Task;

public class Taskdao {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    } 
	 public static int assign(Task t) {
		int status=0;
		try{  
            Connection con=Saveemployee.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into task(empname,empid,title,lastdate)values (?,?,?,?)");  

            ps.setString(1,t.getEmpname());  
            ps.setString(2,t.getEmpid());  
            ps.setString(3,t.getTitle());
            ps.setString(4,t.getLastdate());     
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();} 
		 return status;}
	 

}
