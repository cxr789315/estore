package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface OrderFormMapper {
	void insertOrder(OrderForm order);
	List<OrderForm> selectOrderByCustId(int id);
}
