package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.BookServiceImpl;
import com.briup.estore.service.CategoryServiceImpl;

 
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		List<Category> list = categoryServiceImpl.selectFirstCategory();
		System.out.println("list--------"+list);
		request.setAttribute("categoryList", list);
		
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> list2 = bookServiceImpl.findBookByClick();
		request.setAttribute("bookList", list2);
		
		List<Book> list3 = bookServiceImpl.findAllBook();
		request.setAttribute("allBookList", list3);
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
