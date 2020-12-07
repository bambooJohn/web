package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bambooJohn.bean.User;
import com.bambooJohn.dao.UserDao;
import com.bambooJohn.dao.impl.UserDaoImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * 登录
	 * 		1.取用户名&密码值
	 * 		2.调用dao登录接口
	 * 		3.判断，跳转
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDaoImpl();
		//1.取用户名&密码值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用dao登录接口
		User user = userDao.getUser(new User(null,username,password,null));
		
		if(null == user) {
			//登录失败，转发
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}else {
			//登录成功，重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
