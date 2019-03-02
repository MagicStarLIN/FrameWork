package com.lcl.mapper;

import java.util.List;

import com.lcl.pojo.Emp;

public interface JobLevelMapper {
	//实现针对Job_Level表，通过传入薪资等级，查询等级对应最高和最低薪资，并级联查询在这个薪资范围内的全部员工信息的方法
	public List<Emp> queryEmpWithSalaryLevel(String level) throws Exception;

}
