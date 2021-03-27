package com.ljp.service;

import java.util.List;

import com.ljp.bean.User;
import com.ljp.bean.UserCondition;

public interface UserService {
	boolean register(User user);
	boolean login(User user);
	boolean del(String userId);
	boolean del(List<String> userIds);
	boolean update(User user);
	User searchById(String id);
	User searchByName(String name);
	User searchByEmail(String email);
	User searchByPhone(String phone);
	List<User> searchByCondition(UserCondition UserCondition);
}
