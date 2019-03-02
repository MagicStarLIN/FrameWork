package com.lcl.mapper;

import com.lcl.pojo.Dept;

public interface DeptMapper {
	
	public Dept queryDeptById(Integer id) throws Exception;
}
