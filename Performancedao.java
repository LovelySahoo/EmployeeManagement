package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.maren.model.Performance;

public class Performancedao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Performance p){  
        int status=0;  
        try{  
            Connection con=Performancedao.getConnection();  
            PreparedStatement ps=con.prepareStatement(
                         "insert into performance(name,department,attendence,status)values (?,?,?,?)");  

            ps.setString(1,p.getName());  
            ps.setString(2,p.getDepartment());  
            ps.setString(3,p.getAttendence());
            ps.setString(4,p.getStatus());     
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status; 
         }
    public static List<Performance> getPerformanceaReports(){  
        List<Performance> list=new ArrayList<Performance>();  
          
        try{  
            Connection con=Performancedao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from performance");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Performance p=new Performance();  
                p.setName(rs.getString(1));  
                p.setDepartment(rs.getString(2));
                p.setAttendence(rs.getString(3));
                p.setStatus(rs.getString(4));  
               // e.setAddress(rs.getString(5));  
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
}
