package com.lcl.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lcl.mapper.DeptMapper;
import com.lcl.mapper.EmpMapper;
import com.lcl.mapper.JobLevelMapper;
import com.lcl.mapper.UserMapper;
import com.lcl.pojo.Dept;
import com.lcl.pojo.Emp;
import com.lcl.pojo.User;
import com.lcl.to.Page;

public class UserTest {
	private SqlSessionFactory factory;
	@Before
	public void init() {
		//[1]先拿到图纸，以IO流对象的方式进行加载
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			this.factory = builder.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void Test1() {
		SqlSession sqlSession = factory.openSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		try {
			List<User> list = mapper.queryAllUsers();
			for(User u : list) {
				System.out.println(u.toString());
			}
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void Test2() {
		SqlSession sqlSession = factory.openSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			User u = mapper.queryUserById(3);
			System.out.println(u.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//1.实现针对Emp表，通过传入员工编号，查询员工信息并级联查询员工所在部门信息的方法
	@Test
	public void Test3() {
		SqlSession sqlSession = factory.openSession(false);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		
			try {
				Emp e = mapper.queryEmpByIdWithDept(2);
				System.out.println(e.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@Test
	public void Test4() {
		SqlSession sqlSession = factory.openSession(false);
		UserMapper mapper =sqlSession.getMapper(UserMapper.class);
		
			List<User> userList = null;
			try {
				userList = mapper.queryUserFuzzy("s");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for(User u : userList) {
				System.out.println(u.toString());
			}
	}
	@Test
	public void Test5() {
		SqlSession sqlSession = factory.openSession(false);
		DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
		
		try {
			Dept d = mapper.queryDeptById(3);
			System.out.println(d.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void Test6() {
		SqlSession sqlSession = factory.openSession(false);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		
		try {
			Emp e = mapper.queryEmpByIdWithDeptStep(3);
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void Test7() {
		SqlSession sqlSession = factory.openSession(false);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		try {
			Emp e = mapper.queryEmpByIdwithTotalSalary(3);
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void Test8() {
		SqlSession sqlSession = factory.openSession(false);
		JobLevelMapper mapper = sqlSession.getMapper(JobLevelMapper.class);
		try {
			List<Emp> empList = mapper.queryEmpWithSalaryLevel("初级工资");
			for(Emp e : empList) {
				System.out.println(e.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void Test9() {
		SqlSession sqlSession = factory.openSession(false);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		
		Emp condition = new Emp(null,"乔",null);
		System.out.println(condition);
		
		try {
			Emp e = mapper.queryEmpDynamic(condition);
			System.out.println(e);
			System.out.println(e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void Test10() {
		SqlSession sqlSession = factory.openSession(false);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		
		Page p = new Page(5,10,5);
		
		try {
			List<Emp> list = mapper.queryEmpByPage(p);
			for(Emp e : list) {
				System.out.println(e.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
