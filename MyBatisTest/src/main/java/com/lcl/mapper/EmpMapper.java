package com.lcl.mapper;

import java.util.List;

import com.lcl.pojo.Emp;
import com.lcl.to.Page;

public interface EmpMapper {
	
	//实现针对Emp表，通过传入员工编号，查询员工信息并级联查询员工所在部门信息的方法
	public Emp queryEmpByIdWithDept(Integer id) throws Exception;
	//实现针对Emp表，通过传入员工编号，查询员工信息并分步查询员工所在部门信息的方法
	public Emp queryEmpByIdWithDeptStep(Integer id) throws Exception;
	//实现针对Emp表，通过传入员工编号，通过附加属性totalSalary，查询并计算员工本月工资总值的方法（totalSalary=salary*(1+comm_pct)）
	public Emp queryEmpByIdwithTotalSalary(Integer id) throws Exception;
/**
 * 7.实现针对Emp表按照如下条件的查询操作：
	如果条件中存在员工姓名，则按照员工姓名进行模糊查询
	如果条件中存在员工邮箱，则按照员工邮箱进行模糊查询
	如果条件中存在员工所在部门编号，则按照员工所在部门编号进行查询
	如果上述条件都存在，则按照全部条件进行查询
	如果上述条件仅有部分存在，则按照存在的条件进行查询
	查询结束之后对得到的员工信息按照员工编号进行正序排序
 */
	public Emp queryEmpDynamic(Emp condition) throws Exception;
	//实现针对Emp表的分页查询，每页展示5条员工信息
	public List<Emp> queryEmpByPage(Page page) throws Exception;
}
