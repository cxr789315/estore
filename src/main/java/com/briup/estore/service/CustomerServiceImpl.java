package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{

	//用户名不能重复
	@Override
	public void register(Customer cus) throws Exception {
		//根据用户名查询es_customer,如果查询到一个用户,说明该用户已经被占用
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> cusList = mapper.selectCustomerByName(cus.getName());
		if(cusList.size()>0) {
			throw new Exception("该用户名已经被占用,请重新输入");
		}else {
			mapper.insertCustomer(cus);
		}
		session.commit();
	}

	@Override
	public Customer login(String name,String password) throws Exception {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> list = mapper.selectCustomerByName(name);
		
		if(list.size()>0) {
			Customer cus = list.get(0);
			//判断密码是否正确
			if(cus.getPassword().equals(password)) {
				return cus;
			}else {
				throw new Exception("密码输入错误,请重新输入");
			}
		}else {
			throw new Exception("用户名不存在,请重新输入");
		}
	}
	

}
