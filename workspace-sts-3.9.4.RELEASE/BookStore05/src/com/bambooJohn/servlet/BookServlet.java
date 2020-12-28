package com.bambooJohn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;
import com.bambooJohn.service.BookService;
import com.bambooJohn.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	/**
	 * 查询所有book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	/*protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用service中相应方法
		List<Book> books = bookService.getAllBooks();
		//将books存放到域中
		request.setAttribute("books", books);
		//跳转,book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		
	}*/
	
	/**
	 * 添加book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	/*protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		Book book = new Book(null,title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock),null);
		//调用service
		bookService.addBook(book);
		//跳转，重新查询，book_manager.jsp
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getAllBooks");
		
	}*/
	
	/**
	 * 添加book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		bookService.delBookById(bookId);
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBookByPage");
	}
	
	/**
	 * 通过id获取book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		Book book = bookService.getBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request, response);
	}
	
	/**
	 * 通过id获取book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		//通过判断id值是否为空，执行相应方法
		//调用service
		if(null == id || "".equals(id)) {
			//调用addBook()
			bookService.addBook(new Book(null,title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock),null));
		}else {
			//调用updateBook()
			bookService.updateBook(new Book(Integer.parseInt(id),title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock),null));
		}
		//跳转
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBookByPage");
	}
	
	/**
	 * 分页查询book
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBookByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String pageNo = request.getParameter("pageNo");
		//调用service
		Page<Book> page = bookService.getBookByPage(pageNo);
		//将page存放到域中
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
}
