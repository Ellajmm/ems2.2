package com.sias.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface DepartDao {
	
	//查询总信息
	public int queryTotal();
	//分页查所有部门
	public List<Departments> queryAll(PageBean pb);
	
	//查询did下 总信息
	public int queryCount(String did);
	//分页 部门id下所有员工(传递多值且有对象 则在sql里需要写注解名《一个对象不需要》）
	public List<Employees> queryThis(@Param("id")String id,@Param("pb")PageBean pb);
	
	//根据id查询
	public Departments queryById(String id);
    //查所有
	public List<Departments> findAll();
	//修改
	public void updById(Departments departments);
	
	//添加部门
	public void insertDep(Departments departments);
	
	//查询name=str的信息数、
	public int queryTol(String str);
	//分页 模糊查询name
	public List<Departments> querySome(@Param("str")String str,@Param("pb")PageBean pb);
	

}
