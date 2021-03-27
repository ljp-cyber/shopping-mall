package com.ljp.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.ljp.bean.UserSafe;

public class CommonUtil {
	public static boolean isTelephone(String value) {
		String reg = "^[1]+[3,8]+\\d{9}$";   	
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean isEmail(String value) {
		String reg = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";   	
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static Long isWorkId(String value) {
		if(value.length()==19) {
			try {
				return Long.parseLong(value);
			}catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	public static Date ageToDate(int age) {
		Date date = new Date(System.currentTimeMillis());
		return addYear(date,-age);
	}
	
    public static Date addYear(Date start, int n) {
	    try {
			 Calendar cd = Calendar.getInstance();
			 cd.setTime(start);
			 cd.add(Calendar.YEAR, n);
			 System.out.println(cd.getTime());
			 return cd.getTime();
	     } catch (Exception e) {
	         return null;
	     }
    }
    
	public static UserSafe getSafeInfo(HttpServletRequest request) {
		UserSafe userSafe = new UserSafe();
		userSafe.setLastLoginDate(new Date());
		userSafe.setLastLoginIp(IpUtil.getIpAddr(request));
		String lastSource=request.getHeader("User-Agent");
		if(lastSource.startsWith("Mozilla")) {
			lastSource="WEB";
		}
		userSafe.setLastLoginSource(lastSource);
		//TODO mac查找未实现
		userSafe.setLastLoginMac("");
		return userSafe;
	}

}
