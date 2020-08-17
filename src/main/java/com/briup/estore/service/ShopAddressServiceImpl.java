package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class ShopAddressServiceImpl implements IShopAddressService{

	public List<ShopAddress> selectAddressByCusId(int custId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		List<ShopAddress> addresslist = mapper.selectAddressByCusId(custId);
		return addresslist	;
	}

	@Override
	public ShopAddress selectAddressById(int id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		ShopAddress address = mapper.selectAddressById(id);
		
		return address;
	}

	@Override
	public void insertAddress(ShopAddress shopAddress) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		mapper.insertAddress(shopAddress);
		session.commit();
	}
	
}
