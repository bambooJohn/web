package com.bambooJohn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;
import com.bambooJohn.dao.BookDao;
import com.bambooJohn.dao.impl.BookDaoImpl;

class BookDaoImplTest {

	@Test
	void testGetAllBooks() {
		BookDao bookDao = new BookDaoImpl();
		List<Book> list = bookDao.getAllBooks();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	void testGetBooksByPage() {
		BookDao bookDao = new BookDaoImpl();
		Page<Book> page = new Page<Book> ();
		page.setPageNo(2);
		page = bookDao.getBookByPage(page);
		
		System.out.println("totalPageNo:" + page.getTotalPageNo());
		System.out.println("totalRecord:" + page.getTotalRecord());
		
		List<Book> books = page.getList();
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
	
}
