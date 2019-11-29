package com.maren.model;

import java.io.Serializable;

public class Performance implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String department;
	private String attendence;
	private String status;
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
	public String getAttendence() {
		return attendence;
	}
	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
