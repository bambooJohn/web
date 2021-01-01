package com.bambooJohn.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxDemo
 */
public class AjaxDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		PrintWriter writer = response.getWriter();
		//writer.write("{\"msg\":\"success!!!\"}");
		//writer.write("success!!!");
		writer.write("{\"name\":\"zhangsan\",\"age\":18}");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		System.out.println("name:" + name);
		System.out.println("location:" + location);
	}

}
