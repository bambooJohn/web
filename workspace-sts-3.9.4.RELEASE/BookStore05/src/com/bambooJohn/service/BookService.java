package com.bambooJohn.service;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;

public interface BookService {

	/**
	 * 获取所有书籍信息
	 * @return
	 */
	public List<Book> getAllBooks();
	
	/**
	 * 添加book信息
	 * sql:INSERT INTO books(title,author,price,sales,stock,img_path) VALUES(?,?,?,?,?,?)
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * 删除book通过id
	 * @param id
	 */
	public void delBookById(String id);
	
	/**
	 * 修改book
	 * 		1. 通过id获取Book信息
	 * 		2. updateBook
	 * @param id
	 * @return
	 */
	public Book getBookById(String id);
	
	/**
	 * 修改book
	 * 		sql:update books set title = ?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? where id = ?
	 * @param book
	 */
	public void updateBook(Book book);
	
	/*
	 * 分页查询
	 */
	public Page<Book> getBookByPage(String pageNo);
	
	/**
	 * 带价格区间的分页查询
	 * @param pageNo
	 * @param min
	 * @param max
	 * @return
	 */
	public Page<Book> getBookByPageAndPrice(String pageNo,String min,String max);
}
