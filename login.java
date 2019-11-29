package com.maren.model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class login implements Serializable 
{
	private String name;
	private String password;
	private String usertype;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	

}
