package com.bambooJohn.service.impl;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;
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

	@Override
	public Book getBookById(String id) {
		return bookDao.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public Page<Book> getBookByPage(String pageNo) {
		Page<Book> page = new Page<>();
		int pNo = 1;
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		page.setPageNo(pNo);
		return bookDao.getBookByPage(page);
	}

	@Override
	public Page<Book> getBookByPageAndPrice(String pageNo, String min, String max) {
		Page<Book> page = new Page<>();
		int pNo = 1;
		double minEnd = 0;
		double maxEnd = Double.MAX_VALUE;
		try {
			pNo = Integer.parseInt(pageNo);
			minEnd = Double.parseDouble(min);
			maxEnd = Double.parseDouble(max);
			double temp = 0;
			if(minEnd > maxEnd) {
				temp = minEnd;
				minEnd = maxEnd;
				maxEnd = temp;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		page.setPageNo(pNo);
		return bookDao.getBookByPageAndPrice(page,minEnd,maxEnd);
	}
	
}
