package com.sias.dao;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.User;

public interface UserDao {
	//name+password查询
	public User queryByNameAndPwd(@Param("name")String name,@Param("password")String password);
	
	//姓名查找
	public User queryByName(String name);
	
	//插入
	public void addUser(User user);

}
