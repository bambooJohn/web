package com.bambooJohn.dao;

import com.bambooJohn.bean.User;

public interface UserDao {

	/*
	 * 登录
	 * sql:select * from users where username = ? and password = ?
	 * 
	 */
	User getUser(User user);
	
}
