package com.bambooJohn.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChiCookieServlet
 */
public class ChiCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//持久化
		Cookie cookie = new Cookie("stuAge", "18");
		//cookie.setMaxAge(30);
		//cookie.setMaxAge(0);
		//cookie.setMaxAge(-1);
		cookie.setPath(request.getContextPath() + "/a");
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
