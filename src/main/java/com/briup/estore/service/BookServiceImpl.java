package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> findBookByClick() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = mapper.selectBookByClick();
		return list;
	}

	@Override
	public List<Book> findAllBook() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = mapper.selectAllBook();
		return list;
	}

	@Override
	public Book findBookById(int id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.selectBookById(id);
		//将该书籍的click加1
		book.setClick(book.getClick()+1);
		mapper.updateBook(book);
		session.commit();
		return book;
	}

	@Override
	public List<Book> findBookByCateId(int cateId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> bookList = mapper.selectBookByCateId(cateId);
		return bookList;
	}

	@Override
	public List<Book> findBookByCateIdAndClick(int cateId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> bookList = mapper.selectBookByCateIdAndClick(cateId);
		return bookList;
	}


}
