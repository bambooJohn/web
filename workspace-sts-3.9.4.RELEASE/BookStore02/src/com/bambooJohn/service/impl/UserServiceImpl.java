package com.bambooJohn.service.impl;

import com.bambooJohn.bean.User;
import com.bambooJohn.dao.UserDao;
import com.bambooJohn.dao.impl.UserDaoImpl;
import com.bambooJohn.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.checkUserName(username);
	}

}
