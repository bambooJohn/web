package com.bambooJohn.service.impl;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.dao.BookDao;
import com.bambooJohn.dao.impl.BookDaoImpl;
import com.bambooJohn.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void delBookById(String id) {
		bookDao.delBookById(id);
	}
	
}
