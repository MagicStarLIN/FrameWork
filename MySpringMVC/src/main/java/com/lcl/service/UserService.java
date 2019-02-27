package com.lcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcl.mapper.UserMapper;
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public boolean queryUserLogin(String username,String password) throws Exception{
	
		int result = userMapper.queryUser(username, password);
		if(result == 0) {
			return false;
			
		}else {
			return true;
		}
	}
	
}
