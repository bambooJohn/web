package com.bambooJohn.dao;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;

public interface BookDao {

	/**
	 * 查询所有book信息
	 * sql:select id,title,author,price,sales,stock,img_path from books
	 * @return
	 */
	public List<Book>getAllBooks(); 
	
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
	
	/**
	 * 修改book
	 * sql:select id,title,author,price,sales,stock,img_path from books where 1 = 1 limit ?,?
	 * @param page
	 * @return
	 */
	public Page<Book> getBookByPage(Page<Book> page);
	
}
