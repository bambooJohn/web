package com.bambooJohn.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//购物项集合,key:bookId,value:CartItem
	Map<String, CartItem> map = new LinkedHashMap<>();
	//总数量
	private int totalCount;
	//总金额
	private double totalAmount;
	
	public Cart() {
		super();
	}

	public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
		super();
		this.map = map;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}

	/*
	 * 1.加入购物车
	 * 2.删除购物车
	 * 3.清空购物车
	 * 4.修改购物项的数量
	 * 5.获取所有CartItems
	 */
	/**
	 * 获取所有CartItems
	 * @return
	 */
	public List<CartItem> getCartItems() {
		return new ArrayList<CartItem>(map.values());
	}

	/**
	 * 1.加入购物车
	 * 		本质：将book添加到map中
	 * 		思路：判断购物车中是否购买过该Book
	 * 				* 买过：购买数量+1
	 * 				* 没买过：
	 * 					1.new CartItem()
	 * 					2.setCount()&setBook()
	 * 					3.map.put(cartItem)
	 * 
	 * @param book
	 */
	public void addBookToCart(Book book) {
		//通过bookId获取CartItem
		CartItem cartItem = map.get(book.getId() + "");
		//判断购物车中是否购买过该Book
		if(cartItem == null) {
			//没买过
			cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
		//	map.put(book.getId() + "", cartItem);
		}else {
			//买过
			cartItem.setCount(cartItem.getCount() + 1);
		}
		map.put(book.getId() + "", cartItem);
	}
	
	/**
	 * 2.删除购物车
	 * @return
	 */
	public void delCartItem(Book book) {
		map.remove(book.getId() + "");
	}
	
	/**
	 * 3.清空购物车
	 * @return
	 */
	public void emptyCart() {
		map.clear();
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}


	/**
	 * 计算购物车总数量
	 * @return
	 */
	public int getTotalCount() {
		int totalCount = 0;
		for(CartItem cartItem : getCartItems()) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	
	public double getTotalAmount() {
		/*double totalAmount = 0;
		for(CartItem cartItem : getCartItems()) {
			totalAmount += cartItem.getAmount();
		}
		return totalAmount;*/
		BigDecimal totalAmount = new BigDecimal("0");
		for(CartItem cartItem : getCartItems()) {
			BigDecimal amount = new BigDecimal(cartItem.getAmount() + "");
			totalAmount = totalAmount.add(amount);
		}
		return totalAmount.doubleValue();
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Cart [map=" + map + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}
	
	
	
}
