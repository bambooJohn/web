package com.bambooJohn.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCookieServlet
 */
public class UpdateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//覆盖式
		//Cookie cookie = new Cookie("stuName", "lisi");
		//response.addCookie(cookie);
		//直接式
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("stuName".equals(cookie.getName())) {
				cookie.setValue("wangwu");
				response.addCookie(cookie);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
