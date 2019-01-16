package com.lcl.star;

public class Star {
	private int starid;
	private String sname;
	private int age;
	private int salary;
	public int getStarid() {
		return starid;
	}
	public void setStarid(int starid) {
		this.starid = starid;
	}
	public String getStarname() {
		return sname;
	}
	public void setStarname(String starname) {
		this.sname = starname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Star [starid=" + starid + ", starname=" + sname + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
