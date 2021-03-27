package com.ljp.service;

import java.util.List;

import com.ljp.bean.Brand;

public interface BrandService {
	public List<Brand> queryAll();
	public boolean addOne(Brand b);
	public boolean deleteOne(String id);
	public boolean deleteSome(List<String> ids);
	public boolean updateOne(Brand b);
	
}
