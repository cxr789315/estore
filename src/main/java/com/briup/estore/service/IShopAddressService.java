package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ShopAddress;

public interface IShopAddressService {
	public List<ShopAddress> selectAddressByCusId(int custId);

	public ShopAddress selectAddressById(int id);

	// 插入一个顾客新增的地址
	void insertAddress(ShopAddress shopAddress);
}
