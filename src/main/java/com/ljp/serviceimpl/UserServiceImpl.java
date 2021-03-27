package com.ljp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ljp.bean.User;
import com.ljp.bean.UserCondition;
import com.ljp.bean.UserExample;
import com.ljp.mapper.UserMapper;
import com.ljp.service.UserService;
import com.ljp.utils.CommonUtil;
import com.ljp.utils.IdWorker;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean register(User user) {
		if(user.getName()==null||user.getPassword()==null) {
			return false;
		}
		user.setId(String.valueOf(IdWorker.creatId()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		int insert = userMapper.insert(user);
		if(insert==0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean login(User user) {
		
		return false;
	}

	@Override
	public boolean del(String userId) {
		return userMapper.deleteByPrimaryKey(userId)>0;
	}

	@Override
	public boolean del(List<String> userIds) {
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(userIds);
		return userMapper.deleteByExample(example)>0;
	}

	@Override
	public boolean update(User user) {
		return userMapper.updateByPrimaryKey(user)>0;
	}

	@Override
	public User searchById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User searchByName(String name) {
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> list = userMapper.selectByExample(example);
		return list==null?null:list.get(0);
	}

	@Override
	public User searchByEmail(String email) {
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		return list==null?null:list.get(0);
	}

	@Override
	public User searchByPhone(String phone) {
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> list = userMapper.selectByExample(example);
		return list==null?null:list.get(0);
	}

	@Override
	public List<User> searchByCondition(UserCondition userCondition) {
		System.out.println(userCondition);
		List<User> users=new ArrayList<>();
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		if(userCondition.getKey()!=null&&userCondition.getKey()!="") {
			String key = userCondition.getKey();
			if(CommonUtil.isWorkId(key)!=null) {
				System.out.println("the key is id");
				System.out.println(Long.parseLong(key));
				users.add(searchById(key));
				return users;
			}
			if(CommonUtil.isTelephone(key)) {
				users.add(searchByPhone(key));
				return users;
			}
			if(CommonUtil.isEmail(key)) {
				users.add(searchByEmail(key));
				return users;
			}
			
		}
		if(userCondition.getRole()!=null&&userCondition.getRole()!="") {
			System.out.println("Role");
			criteria.andRoleEqualTo(userCondition.getRole());
		}
		if(userCondition.getBeginAge()!=null||userCondition.getEndAge()!=null) {
			System.out.println("Age");
			int begin = userCondition.getBeginAge()==null?0:userCondition.getBeginAge();
			int end = userCondition.getEndAge()==null?100:userCondition.getEndAge();
			System.out.println(begin+","+end);
			criteria.andBirthdayBetween(CommonUtil.ageToDate(end),CommonUtil.ageToDate(begin));
		}
		List<User> res = userMapper.selectByExample(example);
		return res;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return searchByName(username);
	}

}
