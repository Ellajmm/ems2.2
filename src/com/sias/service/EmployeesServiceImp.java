package com.sias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sias.dao.EmployeesDao;
import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class EmployeesServiceImp implements EmployeesService {
  @Autowired
   private EmployeesDao employeesDao;

  
	@Override
	public List<Employees> queryAll(PageBean pb) {
		int total = employeesDao.queryTotal();
		pb.setPageTotal(total);//完成半成品pb
		return employeesDao.queryAll(pb);
	}

	@Override
	public void delEmpl(String id) {
      employeesDao.delEmp(id);		
	}

	@Override
	public void updEmpl(Employees employee) {
		employeesDao.updEmp(employee);
	}

	@Override
	public Employees queryEmpl(String id) {
		return employeesDao.queryEmp(id);
	}

	@Override
	public List<Departments> queryDep() {
		return employeesDao.queryAllDep() ;
	}

	@Override
	public void insertEmpl(Employees employee) {
		employeesDao.insertEmp(employee);
	}

	@Override
	public List<Employees> querySomeEmps(String str) {
		return employeesDao.querySome(str);
	}

	@Override
	public void deltEmps(List<String> listIds) {
		employeesDao.delSome(listIds);
	}

}
