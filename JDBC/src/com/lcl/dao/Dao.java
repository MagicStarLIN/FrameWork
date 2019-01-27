package com.lcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lcl.bean.Dept;
import com.lcl.util.DBUtil;

public class Dao {
	/**
	 * 查找
	 * @return
	 * @throws Exception
	 */
	public List<Dept> findAllDept() throws Exception{
		//1	定义需要使用的对象，初始值是null	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dept> list = null;
		//2 处理异常
		//3 创建连接对象
		con = DBUtil.getConnection();
		//准备sql语句
		String sql = " select deptno,dname,loc from DEPT ";	
		//5	创建PreparedStatement对象	
		ps = con.prepareStatement(sql);
		//6 创建ResultSet对象
		rs = ps.executeQuery();
		//7	创建ArrayList对象，用于储存查询结果	
		list = new ArrayList<Dept>();
		
		//8 执行查询 如果有 存入列表中
		while(rs.next()){
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
			list.add(dept);
			
		}
		//9 释放资源
		rs.close();
		ps.close();
		con.close();
		//10 把查询结果作为返回值
		return list;
	}
	/**
	 * 增
	 * @param d
	 * @return
	 * @throws Exception
	 */
	public int Adddept(Dept d) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = " insert into dept (deptno,dname,loc) values(?,?,?) ";
		ps = con.prepareStatement(sql);
		ps.setInt(1, d.getDeptno());
		ps.setString(2, d.getDname());
		ps.setString(3, d.getLoc());
		int flag = ps.executeUpdate();
		ps.close();
		con.close();
		return flag;
	}
	/**
	 * 删除
	 * @param deptid
	 * @throws Exception
	 */
	public void Deletedept(int deptid) throws Exception{
			Connection conn = DBUtil.getConnection();
	        //sql, 每行加空格
	        String sql = " delete from dept where deptno=? ";
	        //预编译SQL，减少sql执行
	        PreparedStatement ps = conn.prepareStatement(sql);

	        //传参
	        ps.setInt(1, deptid);

	        //执行
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	}
	/**
	 * 更改
	 * @param d
	 * @throws Exception
	 */
	public void Upadatedept(Dept d) throws Exception{
			Connection conn = DBUtil.getConnection();
			String sql = " update dept set dname = ?,loc = ? where deptno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDname());
			ps.setString(2, d.getLoc());
			ps.setInt(3, d.getDeptno());
			ps.executeUpdate();
			ps.close();
			conn.close();
	}
}
