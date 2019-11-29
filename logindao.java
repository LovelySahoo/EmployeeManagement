package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class logindao{
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3360/project", "root", "root");
		}
		public boolean validation(String name, String password,String usertype) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "select * from login1 where name=? and password=? and usertype=?";
			try {
				con = getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2,password);
				ps.setString(3,usertype);
				ResultSet rs = ps.executeQuery();
					while(rs.next()) 
					 {
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
		
}
			
			


