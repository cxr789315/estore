package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.CustomerServiceImpl;
import com.briup.estore.service.ICustomerService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		ICustomerService customerService = new CustomerServiceImpl();
		String url = "";
		try {
			ShopCar car = new ShopCar();
			Customer customer = customerService.login(name,password);
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			session.setAttribute("car", car);
			url = "/toIndexServlet";
		} catch (Exception e) {
			url = "/WEB-INF/jsp/login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
