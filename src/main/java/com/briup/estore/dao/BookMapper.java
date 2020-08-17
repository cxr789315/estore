package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;

public interface BookMapper {
	List<Book> selectBookByClick();
	List<Book> selectAllBook();
	Book selectBookById(int id);
	void updateBook(Book book);
	List<Book> selectBookByCateId(int cateId);
	List<Book> selectBookByCateIdAndClick(int cateId);
}
