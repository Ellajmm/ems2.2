package com.sias.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface EmployeesService {
	
 public List<Employees> queryAll(PageBean pb);
 
 public void delEmpl(String id);
 
 public void updEmpl(Employees employee);
 
 public Employees queryEmpl(String id);
 
 public List<Departments> queryDep();
 
 public void insertEmpl(Employees employee);
 
 public List<Employees> querySomeEmps(String str);
 
 public void deltEmps(@Param("listIds")List<String> listIds);
}
