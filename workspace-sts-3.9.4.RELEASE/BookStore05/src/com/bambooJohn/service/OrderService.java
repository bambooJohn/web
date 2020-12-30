package com.bambooJohn.service;

import com.bambooJohn.bean.Cart;

import com.bambooJohn.bean.User;

public interface OrderService {

	public String createOrder(Cart cart,User user);
	
}
