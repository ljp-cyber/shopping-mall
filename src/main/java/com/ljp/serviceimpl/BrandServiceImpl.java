package com.ljp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljp.bean.Brand;
import com.ljp.bean.BrandExample;
import com.ljp.bean.BrandExample.Criteria;
import com.ljp.mapper.BrandMapper;
import com.ljp.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandMapper brandMapper;

	@Override
	public List<Brand> queryAll() {
		List<Brand> list = brandMapper.selectByExample(null);
		return list;
	}

	@Override
	public boolean addOne(Brand b) {
		int i = brandMapper.insert(b);
		return i>0;
	}

	@Override
	public boolean deleteOne(String id) {
		brandMapper.deleteByPrimaryKey(id);
		return false;
	}

	@Override
	public boolean deleteSome(List<String> ids) {
		BrandExample brandExample = new BrandExample();
		Criteria criteria = brandExample.createCriteria();
		criteria.andIdIn(ids);
		int i = brandMapper.deleteByExample(brandExample);
		return i>0;
	}

	@Override
	public boolean updateOne(Brand b) {
		int i = brandMapper.updateByPrimaryKeySelective(b);
		return i>0;
	}

}
