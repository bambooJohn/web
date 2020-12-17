package com.bambooJohn.dao.impl;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.dao.BaseDao;
import com.bambooJohn.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		String sql = "select id,title,author,price,sales,stock,img_path from books";
		return getBeanList(sql);
	}

}
