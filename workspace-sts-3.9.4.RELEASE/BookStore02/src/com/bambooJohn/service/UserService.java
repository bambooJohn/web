package com.bambooJohn.service;

import com.bambooJohn.bean.User;

public interface UserService {
	/*
	 * 登录
	 * sql:select * from users where username = ? and password = ?
	 * 
	 */
	User getUser(User user);
	
	/**
	 * 检查用户名是否存在
	 * 		true:用户名存在
	 * 		false:用户名不存在
	 * sql: select * from users where username = ?
	 */
	boolean checkUserName(String username);
}
