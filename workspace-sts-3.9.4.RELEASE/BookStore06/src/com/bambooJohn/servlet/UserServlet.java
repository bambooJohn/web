package com.bambooJohn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bambooJohn.bean.User;
import com.bambooJohn.service.UserService;
import com.bambooJohn.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService = new UserServiceImpl();
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//1.取用户名&密码值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用dao登录接口
		User user = userService.getUser(new User(null,username,password,null));
		
		if(null == user) {
			//登录失败，转发
			request.setAttribute("msg", "用户名或密码输入有误，请重新输入！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {
			//登录成功，重定向
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//取用户名值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//获取验证码
		String code = request.getParameter("code");
		//获取session域中的验证码文件
		Object code2 = session.getAttribute("KAPTCHA_SESSION_KEY");
		//判断验证输入是否正确
		if(code2 != null && code2.toString().equals(code)) {
			//验证码正确
			//调用service中的方法
			boolean yOn = userService.checkUserName(username);
			if(yOn) {
				//用户名存在，转发
				request.setAttribute("msg", "用户名已存在，请重新输入！");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}else {
				//用户名不存在，saveUser()
				//System.out.println("saveUser()");
				userService.saveUser(new User(null,username,password,email));
				//重定向到注册成功界面
				response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
			}
		}else {
			//验证码不正确
			request.setAttribute("msg", "验证码输入错误！");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

	/**
	 * 注销
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将user从session域中移除
		request.getSession().removeAttribute("user");
		//跳转首页
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	
	/**
	 * ajax校验用户名
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		//取username值
		String uname = request.getParameter("uname");
		//调用service
		boolean yOn = userService.checkUserName(uname);
		//响应数据（回调函数）
		/*if(yOn) {
			writer.write("用户名已存在");
		}else {
			writer.write("用户名可用");
		}*/
		writer.print(yOn);
	}
	
}
