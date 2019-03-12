package com.sias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sias.dao.DepartDao;
import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class DepartServiceImp implements DepartService {
 @Autowired
 private DepartDao departDao;
 
 //分页 部门
	@Override
	public List<Departments> queryAllDep(PageBean pb) {
		int total = departDao.queryTotal();
		pb.setPageTotal(total);
		return departDao.queryAll(pb);
	}

	//分页 同一部门员工
	@Override
	public List<Employees> queryEmp(String id, PageBean pb){
		int count = departDao.queryCount(id);
		pb.setPageTotal(count);
		return departDao.queryThis(id, pb);
	}

	//id查this
	@Override
	public Departments queryBid(String id) {
		return departDao.queryById(id);
	}

	//查所有部门
	@Override
	public List<Departments> findDeps() {
		return departDao.findAll();
	}

	@Override
	public void updateDep(Departments departments) {
		departDao.updById(departments);
	}

	@Override
	public void addDep(Departments departments) {
		departDao.insertDep(departments);
	}

	@Override
	public List<Departments> querySomeDep(String str, PageBean pb) {
		int tol = departDao.queryTol(str);
		pb.setPageTotal(tol);
		return departDao.querySome(str, pb);
		
	}

}
