package com.maren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maren.model.Admin;


public class AdminDao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3360/project", "root", "root");
	}
public boolean fetchAdminByname(String name) {
		// TODO Auto-generated method stub
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "select * from admin4 where name=?";
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

public Admin getProfileByname(String name) {
		
		// TODO Auto-generated method stub
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "select*from admin4 where name=?";
	try {
		con = getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1,name);
		 ps.executeQuery();
		 ResultSet rs=ps.getResultSet();
	Admin admin = new Admin();
		if(rs.next()) {
			//admin.setName(name);
		admin.setName(rs.getString("name"));
			admin.setContact(rs.getString("contact"));
			admin.setEmail(rs.getString("email"));
			
		}
		return admin;
	
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


	



