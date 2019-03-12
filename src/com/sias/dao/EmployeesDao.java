package com.sias.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface EmployeesDao {
  //查询总信息数
  public int queryTotal();	
  
  //分页查询所有
  public List<Employees> queryAll(PageBean pb);
  
  //id删除
  public void delEmp(String id);
  
  //id查找
  public Employees queryEmp(String id);
  
  //修改
  public void updEmp(Employees employee);
  
  //查所有部门
  public List<Departments> queryAllDep();
  
  //插入员工
  public void insertEmp(Employees employee);
  
  //name模糊查
  public List<Employees> querySome(String str);
  
  //批量删除
  public void delSome(@Param("listIds") List<String> listIds);
}
