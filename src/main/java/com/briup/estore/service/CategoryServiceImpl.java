package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CategoryServiceImpl implements ICategoryService{


	@Override
	public List<Category> selectFirstCategory() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
		List<Category> list = mapper.selectFirstCategory();
		return list;
	}

}
