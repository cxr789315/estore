package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookService {
	List<Book> findBookByClick();
	List<Book> findAllBook();
	Book findBookById(int id);
	List<Book> findBookByCateId(int cateId);
	List<Book> findBookByCateIdAndClick(int cateId);
} 
