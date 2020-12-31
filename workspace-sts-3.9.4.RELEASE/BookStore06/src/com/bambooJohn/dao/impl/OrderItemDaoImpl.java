package com.bambooJohn.dao.impl;

import com.bambooJohn.bean.OrderItem;
import com.bambooJohn.dao.BaseDao;
import com.bambooJohn.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public void insertOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO order_item(`count`,amount,title,author,price,img_path,order_id) VALUES(?,?,?,?,?,?,?)";
		this.update(sql, orderItem.getCount(),orderItem.getAmount(),orderItem.getTitle(),orderItem.getAuthor(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getOrderId());
	}

	@Override
	public void insertOrderItem(Object[][] params) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO order_item(`count`,amount,title,author,price,img_path,order_id) VALUES(?,?,?,?,?,?,?)";
		this.batchUpdate(sql, params);
	}

}
