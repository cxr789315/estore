package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Customer;

public interface CustomerMapper {
	void insertCustomer(Customer cus);
	List<Customer> selectCustomerByName(String name);
}
