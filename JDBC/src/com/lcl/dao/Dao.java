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
	 * ����
	 * @return
	 * @throws Exception
	 */
	public List<Dept> findAllDept() throws Exception{
		//1	������Ҫʹ�õĶ��󣬳�ʼֵ��null	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dept> list = null;
		//2 �����쳣
		//3 �������Ӷ���
		con = DBUtil.getConnection();
		//׼��sql���
		String sql = " select deptno,dname,loc from DEPT ";	
		//5	����PreparedStatement����	
		ps = con.prepareStatement(sql);
		//6 ����ResultSet����
		rs = ps.executeQuery();
		//7	����ArrayList�������ڴ����ѯ���	
		list = new ArrayList<Dept>();
		
		//8 ִ�в�ѯ ����� �����б���
		while(rs.next()){
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
			list.add(dept);
			
		}
		//9 �ͷ���Դ
		rs.close();
		ps.close();
		con.close();
		//10 �Ѳ�ѯ�����Ϊ����ֵ
		return list;
	}
	/**
	 * ��
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
	 * ɾ��
	 * @param deptid
	 * @throws Exception
	 */
	public void Deletedept(int deptid) throws Exception{
			Connection conn = DBUtil.getConnection();
	        //sql, ÿ�мӿո�
	        String sql = " delete from dept where deptno=? ";
	        //Ԥ����SQL������sqlִ��
	        PreparedStatement ps = conn.prepareStatement(sql);

	        //����
	        ps.setInt(1, deptid);

	        //ִ��
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	}
	/**
	 * ����
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
