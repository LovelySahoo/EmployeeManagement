package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.maren.model.Project;

public class Projectdao {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	 public static int submit(Project p){  
	        int status=0;  
	        try{  
	            Connection con=Saveemployee.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into project(pname,lastdate,subdate)values (?,?,?)");  

	            ps.setString(1,p.getPname());  
	            ps.setString(2,p.getLastdate());  
	            ps.setString(3,p.getSubdate());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }

}
