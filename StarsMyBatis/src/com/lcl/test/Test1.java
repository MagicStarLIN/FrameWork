package com.lcl.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lcl.star.Star;
import com.lcl.util.DBUtil;

public class Test1 {
	@Test
	public void testInsert(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.insertStar";
		for (int i = 1; i < 51; i++) {
			Star s = new Star();
			s.setStarid(i);
			s.setStarname("star"+i);
			s.setAge(22);
			s.setSalary(1000+i);
			int retResult = sqlSession.insert(statement, s);
			System.out.println(s.toString());
		//	System.out.println(retResult);
		}
		sqlSession.close();
	}
	@Test
	public void testSelect(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.selectStar";
		Star s = sqlSession.selectOne(statement, 20);
		System.out.println(s.toString());
		sqlSession.close();
	}
	@Test
	public void deleteAll(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.deleteStar";
		for (int i = 1; i < 51; i++) {
			int retResult = sqlSession.delete(statement, i);
		}
		sqlSession.close();
	}
	@Test
	public void selectlimit(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.selectStar";
		for (int i = 1; i < 51; i++) {
			Star s = sqlSession.selectOne(statement, i);
		//	System.out.println(s.toString());
			int j = Integer.valueOf(s.getSalary()).intValue();
			if(100020<j&&j<100030){
				System.out.println(s.toString());
			}
		}
	}
	@Test
	public void selectMax(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.selectMax";
		Star s = sqlSession.selectOne(statement);
		System.out.println(s);
	}
	@Test
	public void selectcount(){
		SqlSession sqlSession = DBUtil.getSqlSession(true);
		String statement = "com.lcl.Mapper.StarMapper.selectcount";
		int retResult = sqlSession.selectOne(statement);
		
		System.out.println(retResult);
		}


}
