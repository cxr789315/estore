package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Category;

public interface CategoryMapper {
	List<Category> selectFirstCategory();
}
