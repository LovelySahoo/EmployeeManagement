package com.maren.model;

import java.io.Serializable;

public class Attendence implements Serializable{
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	private String name;
	private String department;
	private String status;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
