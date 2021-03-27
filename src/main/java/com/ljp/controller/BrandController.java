package com.ljp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljp.bean.Brand;
import com.ljp.service.BrandService;

@RestController
@CrossOrigin
@RequestMapping("tc/shop/goods/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/list")
	public List<Brand> queryAll(){
		return brandService.queryAll();
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestBody(required = true)List<String> ids) {
		return brandService.deleteSome(ids);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody(required = true) Brand b) {
		return brandService.updateOne(b);
	}
	
	@PutMapping("/insert")
	public boolean insert(@RequestBody(required = true)Brand b) {
		return brandService.addOne(b);
	}
}
