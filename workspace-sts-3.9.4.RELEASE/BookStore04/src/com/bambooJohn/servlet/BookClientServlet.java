package com.bambooJohn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;
import com.bambooJohn.service.BookService;
import com.bambooJohn.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();
	
	protected void getBookByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String pageNo = request.getParameter("pageNo");
		//调用service
		Page<Book> page = bookService.getBookByPage(pageNo);
		//将page存放到域中
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}

}
