package com.lcl.pojo;

public class User {
	private Integer uId;
	private String username;
	private String password;
	private String phone;
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}
	
	

}
