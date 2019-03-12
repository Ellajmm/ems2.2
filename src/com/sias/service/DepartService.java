package com.sias.service;

import java.util.List;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface DepartService {
	
	//分页查所有部门
	public List<Departments> queryAllDep(PageBean pb);
	
	//分页 部门id查询
	public List<Employees> queryEmp(String id,PageBean pb);
	
	//根据id查询
	public Departments queryBid(String id);
	//查所有
	public List<Departments> findDeps();
	
	//修改
    public void updateDep(Departments departments);
    
    //添加
    public void addDep(Departments departments);
    
    //分页 模糊查询name
  	public List<Departments> querySomeDep(String str,PageBean pb);

}
