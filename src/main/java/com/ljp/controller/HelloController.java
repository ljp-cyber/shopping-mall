package com.ljp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljp.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	protected UserService userService;
	
	@GetMapping("/login")
	public boolean login() {
		return false;
	}

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
