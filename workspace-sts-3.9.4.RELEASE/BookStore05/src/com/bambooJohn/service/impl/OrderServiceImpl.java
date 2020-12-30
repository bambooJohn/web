package com.bambooJohn.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bambooJohn.bean.Cart;
import com.bambooJohn.bean.CartItem;
import com.bambooJohn.bean.Order;
import com.bambooJohn.bean.OrderItem;
import com.bambooJohn.bean.User;
import com.bambooJohn.dao.BookDao;
import com.bambooJohn.dao.OrderDao;
import com.bambooJohn.dao.OrderItemDao;
import com.bambooJohn.dao.impl.BookDaoImpl;
import com.bambooJohn.dao.impl.OrderDaoImpl;
import com.bambooJohn.dao.impl.OrderItemDaoImpl;
import com.bambooJohn.service.OrderService;


public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	
	/**
	 * 去结账createOrder
	 * 	1.生成订单
	 * 	2.生成订单详情
	 * 	3.更改相应book的库存和销量
	 * 	4.清空购物车
	 * 
	 */
	@Override
	public String createOrder(Cart cart,User user) {
		// TODO Auto-generated method stub
		//1. 生成订单
		String orderId = System.currentTimeMillis() + "" + user.getId();
		orderDao.insertOrder(new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId()));
		//获取所有购物项
		List<CartItem> cartItems = cart.getCartItems();
		//遍历购物项，添加到订单详情
		for (CartItem cartItem : cartItems) {
			//2. 生成订单详情
			OrderItem orderItem = new OrderItem(null, cartItem.getCount(), cartItem.getAmount(), cartItem.getBook().getTitle(), cartItem.getBook().getAuthor(), cartItem.getBook().getPrice(), cartItem.getBook().getImgPath(), orderId);
			orderItemDao.insertOrderItem(orderItem);
			//3.更改相应book的库存和销量
			int sales = cartItem.getBook().getSales() + cartItem.getCount(); // 计算最终销量
			int stock = cartItem.getBook().getStock() - cartItem.getCount(); // 计算最终库存
			int id = cartItem.getBook().getId();
			bookDao.updateBook(sales, stock, id);
			
		}
		
		cart.emptyCart();
		return orderId;
		
	}

}
