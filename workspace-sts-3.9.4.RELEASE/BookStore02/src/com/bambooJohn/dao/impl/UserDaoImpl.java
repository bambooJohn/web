package com.bambooJohn.dao.impl;

import com.bambooJohn.bean.User;
import com.bambooJohn.dao.BaseDao;
import com.bambooJohn.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,username,`password`,email FROM users where username = ? AND `password` = ?";
		return this.getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,username,`password`,email FROM users where username = ?";
		User user = this.getBean(sql,username);
		return user != null;
	}

}
