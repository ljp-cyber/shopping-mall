package com.ljp.bean;

public class UserCondition {
	private String key;
	private Integer beginAge;
	private Integer endAge;
	private String role;
	
	public UserCondition() {}
	public UserCondition(String key, Integer beginAge, Integer endAge, String role) {
		super();
		this.key = key;
		this.beginAge = beginAge;
		this.endAge = endAge;
		this.role = role;
	}
	
	public Integer getBeginAge() {
		return beginAge;
	}
	
	public Integer getEndAge() {
		return endAge;
	}
	
	
	public String getKey() {
		return key;
	}
	public String getRole() {
		return role;
	}
	public void setBeginAge(Integer beginAge) {
		this.beginAge = beginAge;
	}
	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserCondition [key=" + key + ", beginAge=" + beginAge + ", endAge=" + endAge + ", role=" + role + "]";
	}
	
	
}
