package com.lcl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lcl.pojo.User;

public interface UserMapper {
//1.实现针对User表的全部用户查询功能
	public List<User> queryAllUsers() throws Exception;
//2.实现针对User表，通过u_id查询一个用户信息的功能
	public User queryUserById(Integer id) throws Exception;
//3.模糊查询
	public List<User> queryUserFuzzy(@Param("word")String word) throws Exception;
}
