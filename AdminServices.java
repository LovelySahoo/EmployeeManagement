package com.maren.services;

import com.maren.dao.AdminDao;
import com.maren.model.Admin;


public class AdminServices {
	AdminDao admindao = new AdminDao();
	public boolean checkAdmin(String name) {
		return admindao.fetchAdminByname(name);
	}
	public Admin getadmin(String name) {
		return admindao.getProfileByname(name);
		
	}

}
