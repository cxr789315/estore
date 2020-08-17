package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.BookServiceImpl;
import com.briup.estore.service.IBookService;

public class AddshopcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		if(id!=null) {
		//根据id查询书籍信息
		IBookService bookServiceImpl = new BookServiceImpl();
		Book book = bookServiceImpl.findBookById(Integer.parseInt(id));
		OrderLine line = new OrderLine();
		line.setBook(book);
		line.setNum(Integer.parseInt(num));
		line.setCost(book.getPrice()*line.getNum());
		//从session中获取shopcar
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		if(car!=null) {
			car.addShopCar(line);
		}
		request.getRequestDispatcher("/WEB-INF/user/jsp/shopcar.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/user/jsp/shopcar.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
