package com.ljp.service;

import java.util.List;

import com.ljp.bean.UserSafe;

public interface UserSafeService {
	
	int NONE = 0;
	int SAFE = 1;
	int IPE_XP = 2;
	int MAC_EXP = 3;
	int SOURCE_EXP = 4;
	
	public int updateInfo(UserSafe safe);
	
	public List<UserSafe> queryAll();
}
