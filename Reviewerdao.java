package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maren.model.Reviewer;

public class Reviewerdao {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Reviewer r){  
	        int status=0;  
	        try{  
	            Connection con=Reviewerdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into reviewor(name,id,email,contact)values (?,?,?,?)");  

	            ps.setString(1,r.getName());  
	            ps.setString(2,r.getId());  
	            ps.setString(3,r.getEmail());
	            ps.setString(4,r.getContact());     
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    
	    public static List<Reviewer> getAllReviewer(){  
	        List<Reviewer> list=new ArrayList<Reviewer>();  
	          
	        try{  
	            Connection con=Reviewerdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from reviewor");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Reviewer r=new Reviewer();  
	                r.setName(rs.getString(1));  
	                r.setId(rs.getString(2));
	                r.setEmail(rs.getString(3));
	                r.setContact(rs.getString(4));  
	                //s.setDepartment(rs.getString(5));  
	                list.add(r);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
		public boolean checkReviewer(String name) {
			// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "select * from reviewor where name=?";
			try {
				con = getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return false;
		}
public Reviewer getProfileByname(String name) {
			
			// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select*from reviewor where name=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			 ps.executeQuery();
			 ResultSet rs=ps.getResultSet();
		Reviewer reviewer = new Reviewer();
			if(rs.next()) {
			reviewer.setName(rs.getString("name"));
			reviewer.setId(rs.getString("id"));
			reviewer.setEmail(rs.getString("email"));
			reviewer.setContact(rs.getString("contact"));
			}
			return reviewer;
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
