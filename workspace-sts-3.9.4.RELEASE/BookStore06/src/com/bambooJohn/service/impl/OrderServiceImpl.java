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
	 * 批处理优化结账
	 * 	* 1. BaseDao:添加batchUpdate()
	 * 		* queryRunner.batch(connection,sql,params)
	 * 		* params:Object[][]
	 * 		* 一维：次数
	 * 		* 二维：参数
	 * 	* 2. OrderItemDao添加批处理接口
	 * 	* 3. BookDao添加批处理接口
	 * 	* 4. OrderServiceImpl调用dao批处理接口
	 * 	*		* Object[][] orderItemParams = new Object[cartItems.size()][];
	 * 			  Object[][] bookParams = new Object[cartItems.size()][];
	 * 			* orderItemParams[i] = new Object[]{参数顺序};
	 * 
	 * 使用事务优化结账
	 * 		* 开启事务：connection.setAutoCommit(false);|commit(); rollback()
	 * 			1. 共用同一个connection
	 * 				* ThreadLocal管理Connection
	 * 				* 删除BaseDao中的JDBCUtils.releaseConnection(connection);
	 * 			2. 统一处理异常（Filter）
	 * 				* 抛出BaseDao和BaseServlet中的异常，统一在Filter中处理
	 * 				* 统一开启事务，提交|回滚事务。
	 */
	@Override
	public String createOrder(Cart cart,User user) {
		// TODO Auto-generated method stub
		//1. 生成订单
		String orderId = System.currentTimeMillis() + "" + user.getId();
		orderDao.insertOrder(new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId()));
		//获取所有购物项
		List<CartItem> cartItems = cart.getCartItems();
		Object[][] orderItemParams = new Object[cartItems.size()][];
		Object[][] bookParams = new Object[cartItems.size()][];
		//遍历购物项，添加到订单详情
		for (int i = 0;i < cartItems.size();i++) {
			//2. 生成订单详情
			CartItem cartItem = cartItems.get(i);
			/*OrderItem orderItem = new OrderItem(null, cartItem.getCount(), cartItem.getAmount(), cartItem.getBook().getTitle(), cartItem.getBook().getAuthor(), cartItem.getBook().getPrice(), cartItem.getBook().getImgPath(), orderId);
			orderItemDao.insertOrderItem(orderItem);*/
			//orderItemParams第二维赋值
			orderItemParams[i] = new Object[]{cartItem.getCount(), 
					cartItem.getAmount(), cartItem.getBook().getTitle(), 
					cartItem.getBook().getAuthor(), cartItem.getBook().getPrice(), 
					cartItem.getBook().getImgPath(), orderId};
			//3.更改相应book的库存和销量
			int sales = cartItem.getBook().getSales() + cartItem.getCount(); // 计算最终销量
			int stock = cartItem.getBook().getStock() - cartItem.getCount(); // 计算最终库存
			int id = cartItem.getBook().getId();
			bookParams[i] = new Object[] {sales,stock,id};
			//bookDao.updateBook(sales, stock, id);
			
		}
		orderItemDao.insertOrderItem(orderItemParams);
		bookDao.updateBook(bookParams);
		cart.emptyCart();
		return orderId;
		
	}

}
