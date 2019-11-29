package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maren.model.Employee;

public class Saveemployee {

	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3360/project","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Employee e){  
	        int status=0;  
	        try{  
	            Connection con=Saveemployee.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into employee(empname,empid,email,contact,address) values (?,?,?,?,?)");  

	            ps.setString(1,e.getEmpname());  
	            ps.setString(2,e.getEmpid());  
	            ps.setString(3,e.getEmail());
	            ps.setString(4,e.getContact());  
	            ps.setString(5,e.getAddress());  
	            
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static List<Employee> getAllEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	          
	        try{  
	            Connection con=Saveemployee.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Employee e=new Employee();  
	                e.setEmpname(rs.getString(1));  
	                e.setEmpid(rs.getString(2));
	                e.setEmail(rs.getString(3));
	                e.setContact(rs.getString(4));  
	                e.setAddress(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
		public boolean checkEmployee(String name) {
			// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "select * from employee where empname=?";
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
public Employee getProfileByname(String empname) {
			
			// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select*from employee where empname=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,empname);
			 ps.executeQuery();
			 ResultSet rs=ps.getResultSet();
		Employee employee = new Employee();
			if(rs.next()) {
		
			employee.setEmpname(rs.getString("empname"));
				employee.setEmpid(rs.getString("empid"));
				employee.setEmail(rs.getString("email"));
				employee.setContact(rs.getString("contact"));
				employee.setAddress(rs.getString("address"));
				
				
			}
			return employee;
		
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


