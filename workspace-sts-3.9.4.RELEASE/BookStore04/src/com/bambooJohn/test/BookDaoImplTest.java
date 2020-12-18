package com.bambooJohn.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bambooJohn.bean.Book;
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

}
