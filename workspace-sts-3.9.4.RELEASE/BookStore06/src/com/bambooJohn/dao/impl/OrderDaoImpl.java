package com.bambooJohn.dao.impl;

import com.bambooJohn.bean.Order;
import com.bambooJohn.bean.User;
import com.bambooJohn.dao.BaseDao;
import com.bambooJohn.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orders(id,order_time,total_count,total_amount,state,user_id) VALUES(?,?,?,?,?,?)";
		this.update(sql, order.getId(),order.getOrderTime(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getUserId());
	
	}

}
