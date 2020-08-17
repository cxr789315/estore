package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface IOrderFormService {
	void insertOrder(OrderForm from);
	List<OrderForm> selectOrderByCustId(int custId);
}
