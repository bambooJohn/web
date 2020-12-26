package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Cart;
import com.bambooJohn.service.BookService;
import com.bambooJohn.service.impl.BookServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();
	
	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookId值
		String bookId = request.getParameter("bookId");
		//通过bookId获取Book(BookService)
		Book book = bookService.getBookById(bookId);
		//调用Cart中的addBookToCart
		//Cart存放Session域中
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
		}
	
		cart.addBookToCart(book);
		//存放到Session域中
		session.setAttribute("cart", cart);
		//将title存放到session域中
		session.setAttribute("title", book.getTitle());
		//获取Referer:跳转
		String url = request.getHeader("Referer");
		//跳转
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
		response.sendRedirect(url);
	}

}
