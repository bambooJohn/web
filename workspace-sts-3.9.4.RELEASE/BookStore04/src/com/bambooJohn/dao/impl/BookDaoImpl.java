package com.bambooJohn.dao.impl;

import java.util.List;

import com.bambooJohn.bean.Book;
import com.bambooJohn.bean.Page;
import com.bambooJohn.dao.BaseDao;
import com.bambooJohn.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		String sql = "select id,title,author,price,sales,stock,img_path from books";
		return getBeanList(sql);
	}

	@Override
	public void addBook(Book book) {
		String sql = "INSERT INTO books(title,author,price,sales,stock,img_path) VALUES(?,?,?,?,?,?)";
		update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public void delBookById(String id) {
		String sql = "delete from books where id = ?";
		update(sql, id);
	}

	@Override
	public Book getBookById(String id) {
		String sql = "select id,title,author,price,sales,stock,img_path from books where id = ?";
		return getBean(sql, id);
	}

	@Override
	public void updateBook(Book book) {
		String sql = "update books set title = ?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? where id = ?";
		update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public Page<Book> getBookByPage(Page<Book> page) {
		String sqlCount = "select count(*) from books";
		int totalRecord = Integer.parseInt(this.getSingleValue(sqlCount) + "");
		//将totalRecord赋值
		page.setTotalRecord(totalRecord);
		String sqlList = "select id,title,author,price,sales,stock,img_path from books "
				+ "where 1 = 1 "
				+ "limit ?,?";
		;
		List<Book> list = getBeanList(sqlList, (page.getPageNo() - 1) * page.getPageSize(),page.getPageSize());
		//将list存放到page中
		page.setList(list);
		
		return page;
	}

	

}
