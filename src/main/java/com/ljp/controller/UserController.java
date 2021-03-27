package com.ljp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljp.bean.User;
import com.ljp.bean.UserCondition;
import com.ljp.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/usermanage/user")
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	public UserController() {
		System.out.println("HelloController");
	}
	
	
	@PutMapping("/register")
	public boolean register(@RequestBody(required=true) User user) {
		return userService.register(user);
	}
	
	@PostMapping("update")
	public boolean update(@RequestBody(required=true) User user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestBody(required=true) List<String> userIds) {
		return userService.del(userIds);
	}
	
	@PostMapping("/query")
	public List<User> query(@RequestBody(required=false) UserCondition userCondition){
		if(userCondition==null) {
			userCondition=new UserCondition();
		}
		return userService.searchByCondition(userCondition);
	}
}
