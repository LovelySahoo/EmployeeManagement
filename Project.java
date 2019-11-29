package com.maren.model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Project implements Serializable{
	private String pname;
	private String lastdate;
	private String subdate;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getSubdate() {
		return subdate;
	}
	public void setSubdate(String subdate) {
		this.subdate = subdate;
	}
	

}
