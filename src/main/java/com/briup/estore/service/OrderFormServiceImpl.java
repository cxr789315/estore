package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements IOrderFormService{

	@Override
	public void insertOrder(OrderForm from) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.insertOrder(from);
		session.commit();
	}

	@Override
	public List<OrderForm> selectOrderByCustId(int custId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		List<OrderForm> list = mapper.selectOrderByCustId(custId);
		return list;
	}

}
