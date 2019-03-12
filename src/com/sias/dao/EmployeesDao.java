package com.sias.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface EmployeesDao {
  //��ѯ����Ϣ��
  public int queryTotal();	
  
  //��ҳ��ѯ����
  public List<Employees> queryAll(PageBean pb);
  
  //idɾ��
  public void delEmp(String id);
  
  //id����
  public Employees queryEmp(String id);
  
  //�޸�
  public void updEmp(Employees employee);
  
  //�����в���
  public List<Departments> queryAllDep();
  
  //����Ա��
  public void insertEmp(Employees employee);
  
  //nameģ����
  public List<Employees> querySome(String str);
  
  //����ɾ��
  public void delSome(@Param("listIds") List<String> listIds);
}
