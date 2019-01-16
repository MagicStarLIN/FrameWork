package com.lcl.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lcl.Mapper.StarMapperI;
import com.lcl.star.Star;
import com.lcl.util.DBUtil;

public class Test2 {
	@Test
	public void testadd(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		StarMapperI star = sqlSession.getMapper(StarMapperI.class);
		for (int i = 1; i < 51; i++) {
			Star s = new Star();
			s.setStarid(i);
			s.setStarname("star"+i);
			s.setAge(22);
			s.setSalary(1000+i);
			int add = star.testInsert(s);
			System.out.println(s.toString());
		//	System.out.println(retResult);
		}
		sqlSession.close();
	}
	@Test
	public void testsec(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		StarMapperI star = sqlSession.getMapper(StarMapperI.class);
		Star s = star.testSelect(7);
		System.out.println(s.toString());
	}
	
//	public void testseclimit(){
//		SqlSession sqlSession = DBUtil.getSqlSession(true);
//		StarMapperI star = sqlSession.getMapper(StarMapperI.class);
//		for (int i = 1; i < 51; i++) {
//			Star s = star.selectLimit(1010, 1020);
//		
//		}
//	}
//	
	@Test
	public void testseccount(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		StarMapperI star = sqlSession.getMapper(StarMapperI.class);
		int num = star.selectCount();
		System.out.println(num);
		System.out.println(star.selectCount());
		
	}
}
