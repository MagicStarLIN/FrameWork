package com.lcl.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lcl.star.Star;

public interface StarMapperI {
	
	@Insert ("insert into stars(starid,sname,age,salary)values(#{starid},#{sname},#{age},#{salary})")
	public int testInsert(Star s);
	@Select ("select * from stars where starid = #{starid}")
	public Star testSelect(int id);
	@Select ("select * from stars where starid = #{starid}")
	public Star selectLimit(int min,int max);
	@Select ("select * from stars where salary = (SELECT MAX(salary) FROM stars)")
	public void selectMax();
	@Select ("select count(*) from stars")
	public int selectCount();
	

}
