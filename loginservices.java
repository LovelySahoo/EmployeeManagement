package com.maren.services;

import com.maren.dao.logindao;

/**
 * @author Soumya
 *
 */
public class loginservices {
	logindao logindao = new logindao();
	public boolean loginuser(String name, String password,String usertype) {
		return logindao.validation(name,password,usertype);
	}
	
	

}
