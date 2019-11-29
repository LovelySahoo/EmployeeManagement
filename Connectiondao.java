package com.maren.dao;
	 
	import java.sql.Connection;
	import java.sql.DriverManager;
public class Connectiondao {
	public static Connection createConnection()
	 {
	 Connection con = null;
	 String url = "jdbc:mysql://localhost:3360/project"; 
	 String username = "root"; 
	 String password = "root"; 
	 
	 try 
	 {
	 try 
	 {
	 Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
	 } 
	 catch (ClassNotFoundException e)
	 {
	 e.printStackTrace();
	 } 
	 con = DriverManager.getConnection(url, username, password); //connecting to MySQL database
	 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 return con;
	 }
	}


