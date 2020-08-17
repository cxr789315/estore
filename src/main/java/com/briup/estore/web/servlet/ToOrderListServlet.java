package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.OrderFormServiceImpl;
import com.briup.estore.service.OrderLineServiceImpl;
import com.briup.estore.service.ShopAddressServiceImpl;
import com.briup.estore.utils.MyBatisSqlSessionFactory;


public class ToOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//从session中获取购物车的信息
		ShopCar car =  (ShopCar) session.getAttribute("car");
		//从session中获取customer
		Customer customer = (Customer) session.getAttribute("customer");
		//根据shopaddid查询地址信息
		String addId = request.getParameter("shopAddId");
		IShopAddressService shopAddressServlet = new ShopAddressServiceImpl();
		ShopAddress address = shopAddressServlet.selectAddressById(Integer.parseInt(addId));
		
		//保存订单
		OrderForm orderForm = new OrderForm();
		orderForm.setCost(car.getCost());
		orderForm.setCustomer(customer);
		orderForm.setOrderdate(new Date());
		orderForm.setShopAddress(address);
		IOrderFormService formService = new OrderFormServiceImpl();
		formService.insertOrder(orderForm);
		//保存订单项
		Map<Integer, OrderLine> map = car.getOrderLines();
		Set<Entry<Integer,OrderLine>> entrySet = map.entrySet();
		IOrderLineService lineService = new OrderLineServiceImpl();
		for (Entry<Integer, OrderLine> entry : entrySet) {
			OrderLine line = entry.getValue();
			line.setOrder(orderForm); 
			lineService.insertLine(line);
		}
		//查询当前用户所有的订单信息
		List<OrderForm> orderList = formService.selectOrderByCustId(customer.getId());
		request.setAttribute("orderList", orderList);
		//跳转到orderlist.jsp
		request.getRequestDispatcher("/WEB-INF/user/jsp/orderlist.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
