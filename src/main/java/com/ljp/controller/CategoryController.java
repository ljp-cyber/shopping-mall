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

import com.ljp.bean.Category;
import com.ljp.bean.PageCondition;
import com.ljp.service.CategoryService;

//http://localhost:8080/tc/shop/goods/category/all 
@RestController
@CrossOrigin
@RequestMapping("tc/shop/goods/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/all")
	public List<Category> query(@RequestBody(required=false)PageCondition page){
		System.out.println("query");
		if(page==null) {
			return categoryService.searchByPage(1);
		}
		return categoryService.searchByPage(page.getPage());
	}
	
	@PostMapping("/list")
	public List<Category> query1(@RequestBody(required=false)PageCondition page){
		System.out.println("query");
		if(page==null) {
			return categoryService.searchByPage(1);
		}
		return categoryService.searchByPage(page.getPage());
	}
	
//	@GetMapping("/quert")
//	public List<Category> query(@RequestBody(required=false)PageCondition page){
//		System.out.println("query");
//		if(page==null) {
//			return categoryService.searchByPage(1);
//		}
//		return categoryService.searchByPage(page.getPage());
//	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestBody(required=true) List<String> ids) {
		return categoryService.delByIds(ids);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody(required=true) Category category) {
		return categoryService.update(category);
	}
	
	@PutMapping("/insert")
	public boolean insert(@RequestBody(required=true) Category category) {
		System.out.println("insert");
		return categoryService.add(category);
	}
}
