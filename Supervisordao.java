package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maren.model.Supervisor;



public class Supervisordao {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Supervisor s){  
	        int status=0;  
	        try{  
	            Connection con=Saveemployee.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into supervisor(name,id,email,contact,department)values (?,?,?,?,?)");  

	            ps.setString(1,s.getName());  
	            ps.setString(2,s.getId());  
	            ps.setString(3,s.getEmail());
	            ps.setString(4,s.getContact());     
	            ps.setString(5,s.getDepartment());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
	    
	    public static List<Supervisor> getAllSupervisor(){  
	        List<Supervisor> list=new ArrayList<Supervisor>();  
	          
	        try{  
	            Connection con=Supervisordao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from supervisor");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Supervisor s=new Supervisor();  
	                s.setName(rs.getString(1));  
	                s.setId(rs.getString(2));
	                s.setEmail(rs.getString(3));
	                s.setContact(rs.getString(4));  
	                s.setDepartment(rs.getString(5));  
	                list.add(s);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
		public boolean checkSupervisor(String name) {
			// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "select * from supervisor where name=?";
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
		public Supervisor getProfileByname(String name) {
			
			// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select*from supervisor where name=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			 ps.executeQuery();
			 ResultSet rs=ps.getResultSet();
		Supervisor supervisor = new Supervisor();
			if(rs.next()) {
				//admin.setName(name);
			supervisor.setName(rs.getString("name"));
				supervisor.setContact(rs.getString("contact"));
				supervisor.setEmail(rs.getString("email"));
				
			}
			return supervisor;
		
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



