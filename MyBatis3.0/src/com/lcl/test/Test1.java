package com.lcl.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lcl.formobject.Dept;
import com.lcl.util.DBUtil;

public class Test1 {
	@Test
	public void testselect(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.mapper.MapperI.findDeptandEmp";
		Dept d = sqlSession.selectOne(statement,1);
		System.out.println(d);
	}
	@Test
	public void testselectMax(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.mapper.MapperI.findDeptandEmpMAXSALARY";
		Dept d = sqlSession.selectOne(statement);
		System.out.println(d);
	}
}
