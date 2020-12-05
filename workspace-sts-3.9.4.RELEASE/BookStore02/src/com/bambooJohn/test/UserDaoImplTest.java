package com.bambooJohn.test;

import org.junit.jupiter.api.Test;

import com.bambooJohn.bean.User;
import com.bambooJohn.dao.UserDao;
import com.bambooJohn.dao.impl.UserDaoImpl;

class UserDaoImplTest {

	private UserDao userDao = new UserDaoImpl();
	
	@Test
	void testGetUser() {
		User user = userDao.getUser(new User(null,"test01","test01",null));
		
		System.out.println(user);
	}

}
