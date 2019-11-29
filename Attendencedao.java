package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.maren.model.Attendence;

public class Attendencedao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
 public static int assign(Attendence a) {
	int check=0;
	try{  
        Connection con=Attendencedao.getConnection();  
        PreparedStatement ps=con.prepareStatement(  
                     "insert into attendence(name,department,status,date)values (?,?,?,?)");  

        ps.setString(1,a.getName());  
        ps.setString(2,a.getDepartment());  
        ps.setString(3,a.getStatus());
        ps.setString(4,a.getDate());     
        check=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();} 
	 return check;}
 public static List<Attendence> getAttendencetable(){  
     List<Attendence> list=new ArrayList<Attendence>();  
       
     try{  
         Connection con=Attendencedao.getConnection();  
         PreparedStatement ps=con.prepareStatement("select * from attendence");  
         ResultSet rs=ps.executeQuery();  
         while(rs.next()){  
             Attendence a=new Attendence();  
             a.setName(rs.getString(1));  
             a.setDepartment(rs.getString(2));
             a.setStatus(rs.getString(3));
             a.setDate(rs.getString(4));  
            // s.setDepartment(rs.getString(5));  
             list.add(a);  
         }  
         con.close();  
     }catch(Exception e){e.printStackTrace();}  
       
     return list;  
 }

}
