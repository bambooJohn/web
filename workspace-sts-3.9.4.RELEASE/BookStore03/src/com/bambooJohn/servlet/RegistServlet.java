package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bambooJohn.bean.User;
import com.bambooJohn.service.UserService;
import com.bambooJohn.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 注册
	 * 		1.取值
	 * 		2.检验用户名是否存在
	 * 			1.不存在：调用saveUser()，保存用户信息
	 * 			2.存在：跳转回注册页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService userService = new UserServiceImpl();
		//取用户名值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//调用service中的方法
		boolean yOn = userService.checkUserName(username);
		if(yOn) {
			//用户名存在，转发
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
		}else {
			//用户名不存在，saveUser()
			System.out.println("saveUser()");
			userService.saveUser(new User(null,username,password,email));
			//重定向到注册成功界面
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
