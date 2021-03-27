package com.ljp.service;

import java.util.List;

import com.ljp.bean.Category;

public interface CategoryService {
	boolean delById(String id);
	boolean delByIds(List<String> id);
	boolean update(Category category);
	boolean add(Category category);
	
	Category searchById(String id);
	Category searchByName(String name);
	List<Category> searchByPage(int page);
}
