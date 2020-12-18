package com.bambooJohn.service;

import java.util.List;

import com.bambooJohn.bean.Book;

public interface BookService {

	/**
	 * 获取所有书籍信息
	 * @return
	 */
	public List<Book> getAllBooks();
	
	public void addBook(Book book);
	
	public void delBookById(String id);
	
	public Book getBookById(String id);
	
	public void updateBook(Book book);
}
