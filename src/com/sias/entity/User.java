package com.sias.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String id;//ID VARCHAR2(10) PRIMARY KEY,
	private String name;//NAME NVARCHAR2(20) unique,
	private String realName;//REALNAME NVARCHAR2(20),
	private String password;//PASSWORD VARCHAR2(6),
	private Integer sex;//0--girl 1--boy SEX NUMBER(1)
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String realName, String password,
			Integer sex) {
		super();
		this.id = id;
		this.name = name;
		this.realName = realName;
		this.password = password;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", realName=" + realName
				+ ", password=" + password + ", sex=" + sex + "]";
	}
	
	
}
