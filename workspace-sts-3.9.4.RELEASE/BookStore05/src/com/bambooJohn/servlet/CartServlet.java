package com.bambooJohn.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

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
	
	/**
	 * 添加Book到Cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookId值
		String bookId = request.getParameter("bookId");
		//通过bookId获取Book(BookService)
		Book book = bookService.getBookById(bookId);
		//调用Cart中的addBookToCart
		//Cart
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			//存放Session域中
			session.setAttribute("cart", cart);
		}
	
		cart.addBookToCart(book);
		//验证库存问题
		int count = cart.getMap().get(bookId).getCount();
		int stock = book.getStock();
		
		if(count > stock) {
			//库存不足
			session.setAttribute("msg", "库存不足，仅剩" + stock + "件商品");
			//将最大库存设置为购买商品数量
			cart.getMap().get(bookId).setCount(stock);
			
		}else {
			//将title存放到session域中
			session.setAttribute("title", book.getTitle());
		}
		
		//获取Referer:跳转
		String url = request.getHeader("Referer");
		//跳转
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
		response.sendRedirect(url);
	}
	
	/**
	 * 删除购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		
		Book book = bookService.getBookById(bookId);
		//调用Cart中的addBookToCart
		//Cart存放Session域中
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.delCartItem(book);
		}
		
		//存放到Session域中
		session.setAttribute("cart", cart);
		//获取Referer:跳转
		String url = request.getHeader("Referer");
		//跳转
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");

	}
	
	
	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void emptyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.removeAttribute("cart");
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.emptyCart();
		}
		
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}
	

	/**
	 * 修改购物车商品数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookId,count值
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		//调用Cart
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.updateCartItem(bookId, count);
		}
		//跳转
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}
	
}
