package com.sias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sias.dao.UserDao;
import com.sias.entity.User;

@Service //创建Service
@Transactional(propagation=Propagation.REQUIRED)//加事务
public class UserServiceImp implements UserService {
	@Autowired //自动注入dao（配置时接口首字母小写）
	private UserDao userDao;

	
	@Override
	public User queryUser(String name, String password) {
		return userDao.queryByNameAndPwd(name, password);
	}


	@Override
	public void insertUser(User user) {
     userDao.addUser(user);		
	}


	@Override
	public User queryByNa(String name) {
		return userDao.queryByName(name);
	}

}
