package com.briup.estore.service;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService{

	@Override
	public void insertLine(OrderLine orderLine) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.insertLine(orderLine);
		session.commit();
	}

}
