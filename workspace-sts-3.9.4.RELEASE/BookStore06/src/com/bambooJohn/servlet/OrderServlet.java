package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bambooJohn.bean.Cart;
import com.bambooJohn.bean.User;
import com.bambooJohn.service.OrderService;
import com.bambooJohn.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		//调用service
		String orderId = orderService.createOrder(cart, user);
		session.setAttribute("orderId", orderId);
		//跳转
		response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
		
	}

}
