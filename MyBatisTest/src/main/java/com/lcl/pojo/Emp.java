package com.lcl.pojo;

import java.sql.Date;

import com.lcl.pojo.Dept;
import com.lcl.pojo.JobLevel;

public class Emp {
	
	private Integer empId;
	private String eName;
	private String email;
	private String phone;
	private Date hireDate;
	private Integer jobId;
	private Double salary;  //底薪
	private Double commPct;  //奖金率
	private Integer managerId;
	private Integer deptId;
	
	private Double totalSalary;  //总月薪 = salary * (1 + comm_pct)

	private JobLevel jobLevel;
	
	private Dept dept;
	
	public Emp() {
		super();
	}

	public Emp(Integer empId, String eName, String email, String phone, Date hireDate, Integer jobId, Double salary,
			Double commPct, Integer managerId, Integer deptId, Double totalSalary, JobLevel jobLevel, Dept dept) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commPct = commPct;
		this.managerId = managerId;
		this.deptId = deptId;
		this.totalSalary = totalSalary;
		this.jobLevel = jobLevel;
		this.dept = dept;
	}

	public Emp(Integer empId, String eName, String email) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.email = email;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommPct() {
		return commPct;
	}
	public void setCommPct(Double commPct) {
		this.commPct = commPct;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public JobLevel getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(JobLevel jobLevel) {
		this.jobLevel = jobLevel;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", eName=" + eName + ", email=" + email + ", phone=" + phone + ", hireDate="
				+ hireDate + ", jobId=" + jobId + ", salary=" + salary + ", commPct=" + commPct + ", managerId="
				+ managerId + ", deptId=" + deptId + ", totalSalary=" + totalSalary + ", jobLevel=" + jobLevel
				+ ", dept=" + dept + "]";
	}

 

}
