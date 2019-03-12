package com.sias.entity;

import java.io.Serializable;

public class Employees implements Serializable{
	private String id;//ID VARCHAR2(10) PRIMARY KEY,
	private String name;//NAME NVARCHAR2(20),
	private String salary;//SALARY VARCHAR2(6),
	private Integer age;//AGE NUMBER(3),
	private String did;//部门表id DID VARCHAR2(10)
	
	private Departments departments;//关联属性
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	//departments
	public Employees(String id, String name, String salary, Integer age,
			Departments departments) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.departments = departments;
	}
	//did
	public Employees(String id, String name, String salary, Integer age,
			String did) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.did = did;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + ", departments=" + departments + "]";
	}
	
}
