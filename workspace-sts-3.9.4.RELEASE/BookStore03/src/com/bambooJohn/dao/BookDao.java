package com.bambooJohn.dao;

import java.util.List;

import com.bambooJohn.bean.Book;

public interface BookDao {

	/**
	 * 获取所有book信息
	 * sql:select id,title,author,price,sales,stock,img_path from books
	 * @return
	 */
	public List<Book>getAllBooks(); 
	
}
