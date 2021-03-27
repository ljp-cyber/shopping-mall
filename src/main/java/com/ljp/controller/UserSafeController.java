package com.ljp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljp.bean.UserSafe;
import com.ljp.service.UserSafeService;

@RestController
@CrossOrigin
@RequestMapping("/usermanage/userSafe")
public class UserSafeController {
	
	@Autowired
	private UserSafeService safeService;
	
	@GetMapping("/list")
	public List<UserSafe> list(){
		return safeService.queryAll();
	}
}
