package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * 实现登录功能
	 * 	1.获取用户名密码
	 * 	2.判断用户名密码输入是否正确（admin2,dao）
	 * 	3.路径跳转
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.获取用户名密码
		String username = request.getParameter("username");
		System.out.println("username:" + username);
		String pwd = request.getParameter("pwd");
		System.out.println("pwd:" + pwd);
		if("admin2".equals(username) && "admin2".equals(pwd)) {
			//登录成功，跳转login_success.html
			System.out.println("/pages/login_success.html");
			request.getRequestDispatcher("/pages/login_success.html").forward(request, response);
		}else {
			//登录失败，跳转login.html
			System.out.println("path:" + request.getContextPath() + "/pages/login.html");
			response.sendRedirect(request.getContextPath() + "/pages/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
