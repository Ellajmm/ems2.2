package com.sias.dao;

import org.apache.ibatis.annotations.Param;

import com.sias.entity.User;

public interface UserDao {
	//name+password��ѯ
	public User queryByNameAndPwd(@Param("name")String name,@Param("password")String password);
	
	//��������
	public User queryByName(String name);
	
	//����
	public void addUser(User user);

}
