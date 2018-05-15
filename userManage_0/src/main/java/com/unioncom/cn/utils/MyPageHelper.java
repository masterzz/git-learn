package com.unioncom.cn.utils;

import java.util.ArrayList;
import java.util.List;

public class MyPageHelper<T> {
	// 第几页
	private int page;
	// 共多少页
	private int length;
	// 每页有多少行
	private int rows;
	// 查询出来的结果集
	private List<T> list;

	public MyPageHelper(List<T> list) {
		this.list = list;
	}

	public List<T> getPage(int page, int rows) {
		this.page = page;
		this.rows = rows;
		this.length = (int) Math.ceil(list.size() / rows);
		//新建一个list，用来存放第page页数据
		List<T> newlist = new ArrayList<T>();
		//page小于最后一页时
		if(page <length) {
			for(int i = 0; i < rows; i++) {
				newlist.add(list.get((page-1) * rows + i));
			}
		} 
		//page等于最后一页时
		else if(page == length) {
			for(int i = 0; i < list.size() % rows; i++) {
				newlist.add(list.get((page-1) * rows + i));
			}
		}
		
		return newlist;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}
