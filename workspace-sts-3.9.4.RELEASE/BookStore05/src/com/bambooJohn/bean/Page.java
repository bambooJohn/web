package com.bambooJohn.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;						//当前页码				用户
	private int totalPageNo;				//总页数=总条数/每页条数	计算
	private int totalRecord;				//总条数				sql:select count(*) from books
	private static final int PAGE_SIZE = 4; //每页显示的条数			静态常量
	private List<T> list;					//当前页的数据集			dao:sql:select * from books limit (pageNo-1)*pageSize,PAGE_SIZE
	
	public Page() {
		super();
	}

	public Page(int pageNo, int totalPageNo, int totalRecord, List<T> list) {
		super();
		this.pageNo = pageNo;
		this.totalPageNo = totalPageNo;
		this.totalRecord = totalRecord;
		this.list = list;
	}

	public int getPageNo() {
		if(pageNo < 1) {
			return 1;
		}
		if(pageNo > getTotalPageNo()) {
			return getTotalPageNo();
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPageNo() {
		return totalRecord % PAGE_SIZE == 0 ? totalRecord / PAGE_SIZE : totalRecord / PAGE_SIZE + 1;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public static int getPageSize() {
		return PAGE_SIZE;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPageNo=" + totalPageNo + ", totalRecord=" + totalRecord + ", list="
				+ list + "]";
	}

	
	
}
