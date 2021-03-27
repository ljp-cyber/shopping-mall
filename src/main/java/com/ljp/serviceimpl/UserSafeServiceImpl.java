package com.ljp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljp.bean.UserSafe;
import com.ljp.mapper.UserSafeMapper;
import com.ljp.service.UserSafeService;
import com.ljp.utils.ParseIP;

@Service
public class UserSafeServiceImpl implements UserSafeService {
	
	@Autowired
	private UserSafeMapper userSafeMapper;
	
	private int isSafe(UserSafe newSafe,UserSafe dbSafe) { 
		//TODO
		return SAFE;
	}
	
	private boolean creatInfo(UserSafe safe) {
		safe.setRegisterData(safe.getLastLoginDate());
		safe.setRegisterSource(safe.getLastLoginSource());
		safe.setRegisterAdress(ParseIP.parseIp(safe.getLastLoginIp()).getRegion());
		safe.setUpdateDate(safe.getRegisterData());
		return userSafeMapper.insert(safe)>0;
	}

	@Override
	public int updateInfo(UserSafe userSafe) {
		UserSafe dbUserSafe = userSafeMapper.selectByPrimaryKey(userSafe.getUserId());
		if(dbUserSafe==null) {
			if(!creatInfo(userSafe)) {
				return NONE;
			}
			dbUserSafe = userSafeMapper.selectByPrimaryKey(userSafe.getUserId());
		}
		int res = isSafe(userSafe, dbUserSafe);
		System.out.println("updateInfo(UserSafe)"+userSafe);
		userSafeMapper.updateByPrimaryKeySelective(userSafe);
		return res;
	}

	@Override
	public List<UserSafe> queryAll() {
		List<UserSafe> list = userSafeMapper.selectByExample(null);
		return list;
	}
	
	
}
