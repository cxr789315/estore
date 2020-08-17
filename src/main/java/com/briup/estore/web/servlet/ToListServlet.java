package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.BookServiceImpl;
import com.briup.estore.service.IBookService;

public class ToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端传递的二级栏目的id
		String id = request.getParameter("id");
		int cateId = Integer.parseInt(id);
		IBookService bookService = new BookServiceImpl();
		List<Book> bookList = bookService.findBookByCateId(cateId);
		
		List<Book> topBookList = bookService.findBookByCateIdAndClick(cateId);
		request.setAttribute("bookList", bookList);
		request.setAttribute("topBookList", topBookList);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
