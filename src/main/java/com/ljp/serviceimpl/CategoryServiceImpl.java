package com.ljp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljp.bean.Category;
import com.ljp.bean.CategoryExample;
import com.ljp.bean.CategoryExample.Criteria;
import com.ljp.config.CommonConfig;
import com.ljp.mapper.CategoryMapper;
import com.ljp.service.CategoryService;
import com.ljp.utils.IdWorker;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	public CategoryServiceImpl() {
		System.out.println("CategoryServiceImpl.construct()");
	}
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public boolean delById(String id) {
		return categoryMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public boolean update(Category category) {
		return categoryMapper.updateByPrimaryKeySelective(category)>0;
	}

	@Override
	public boolean add(Category category) {
		category.setId(String.valueOf(IdWorker.creatId()));
		return categoryMapper.insert(category)>0;
	}

	@Override
	public Category searchById(String id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public Category searchByName(String name) {
		CategoryExample categoryExample = new CategoryExample();
		Criteria createCriteria = categoryExample.createCriteria();
		createCriteria.andNameEqualTo(name);
		List<Category> list = categoryMapper.selectByExample(categoryExample);
		return list==null?null:list.get(0);
	}

	@Override
	public List<Category> searchByPage(int page) {
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.setOffset((page-1)*CommonConfig.PAGE_SIZE);
		categoryExample.setLimit(CommonConfig.PAGE_SIZE);
		List<Category> list = categoryMapper.selectByExample(categoryExample);
		return list==null?null:list;
	}

	@Override
	public boolean delByIds(List<String> ids) {
		CategoryExample categoryExample = new CategoryExample();
		Criteria createCriteria = categoryExample.createCriteria();
		createCriteria.andIdIn(ids);
		return categoryMapper.deleteByExample(categoryExample)>0;
	}

}
