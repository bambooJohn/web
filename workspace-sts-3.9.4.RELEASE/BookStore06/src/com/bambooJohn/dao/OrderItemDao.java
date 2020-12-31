package com.bambooJohn.dao;

import com.bambooJohn.bean.OrderItem;

public interface OrderItemDao {

	public void insertOrderItem(OrderItem orderItem);
	public void insertOrderItem(Object[][] params);
	
}
