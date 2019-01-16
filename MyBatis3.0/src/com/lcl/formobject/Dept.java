package com.lcl.formobject;

import java.util.List;

public class Dept {

	   private int deptid;      
       private String deptname;     
       private String leader;
       private List<Emp> EmpList;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public List<Emp> getEmpList() {
		return EmpList;
	}
	public void setEmpList(List<Emp> empList) {
		EmpList = empList;
	}
	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", deptname=" + deptname + ", leader=" + leader + ", EmpList=" + EmpList
				+ "]";
	}
	
}
