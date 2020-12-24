package com.bambooJohn.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReSubServlet
 */
public class ReSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid2 = request.getParameter("uuid2");
		//分别取session域和隐藏域中的uuid值
		HttpSession session = request.getSession();
		Object uuid = session.getAttribute("uuid");
		//判断是否相等
		if(uuid != null && uuid.toString().equals(uuid2)) {
			//相等：提交，移除session域中的token
			System.out.println("提交啦！！！");
			session.removeAttribute("uuid");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
