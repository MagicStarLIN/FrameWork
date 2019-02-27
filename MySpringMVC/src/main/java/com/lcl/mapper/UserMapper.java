package com.lcl.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
	public Integer queryUser(@Param("username")String username,@Param("password")String password)throws Exception;
}
