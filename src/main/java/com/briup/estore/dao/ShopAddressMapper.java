package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface ShopAddressMapper {
	List<ShopAddress> selectAddressByCusId(int custId);
	ShopAddress selectAddressById(int id);
	
	//插入一个顾客新增的地址
	void insertAddress(ShopAddress shopAddress);
}
