package com.bambooJohn.service;

import com.bambooJohn.bean.User;

public interface UserService {
	/*
	 * 登录
	 * sql:select * from users where username = ? and password = ?
	 * 
	 */
	User getUser(User user);
}
