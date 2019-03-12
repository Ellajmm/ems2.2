package com.sias.service;

import java.util.List;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface DepartService {
	
	//��ҳ�����в���
	public List<Departments> queryAllDep(PageBean pb);
	
	//��ҳ ����id��ѯ
	public List<Employees> queryEmp(String id,PageBean pb);
	
	//����id��ѯ
	public Departments queryBid(String id);
	//������
	public List<Departments> findDeps();
	
	//�޸�
    public void updateDep(Departments departments);
    
    //���
    public void addDep(Departments departments);
    
    //��ҳ ģ����ѯname
  	public List<Departments> querySomeDep(String str,PageBean pb);

}
