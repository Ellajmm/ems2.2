package com.sias.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

public interface DepartDao {
	
	//��ѯ����Ϣ
	public int queryTotal();
	//��ҳ�����в���
	public List<Departments> queryAll(PageBean pb);
	
	//��ѯdid�� ����Ϣ
	public int queryCount(String did);
	//��ҳ ����id������Ա��(���ݶ�ֵ���ж��� ����sql����Ҫдע������һ��������Ҫ����
	public List<Employees> queryThis(@Param("id")String id,@Param("pb")PageBean pb);
	
	//����id��ѯ
	public Departments queryById(String id);
    //������
	public List<Departments> findAll();
	//�޸�
	public void updById(Departments departments);
	
	//��Ӳ���
	public void insertDep(Departments departments);
	
	//��ѯname=str����Ϣ����
	public int queryTol(String str);
	//��ҳ ģ����ѯname
	public List<Departments> querySome(@Param("str")String str,@Param("pb")PageBean pb);
	

}
