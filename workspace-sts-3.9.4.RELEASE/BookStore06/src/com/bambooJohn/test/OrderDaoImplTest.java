package com.bambooJohn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.bambooJohn.bean.Order;
import com.bambooJohn.bean.OrderItem;
import com.bambooJohn.dao.OrderDao;
import com.bambooJohn.dao.OrderItemDao;
import com.bambooJohn.dao.impl.OrderDaoImpl;
import com.bambooJohn.dao.impl.OrderItemDaoImpl;

class OrderDaoImplTest {

	@Test
	void testInsertOrder() {

		OrderDao orderDao = new OrderDaoImpl();
		orderDao.insertOrder(new Order("test001", new Date(), 2, 300, 0, 1));
	}

	@Test
	void testInsertOrderItem() {

		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		orderItemDao.insertOrderItem(new OrderItem(null,1,150,"testt","testa",150,"testt","test001"));
	}
}
