package com.sias.entity;

import java.io.Serializable;

public class Departments implements Serializable{
	private String id;
	private String name;
	private String note;
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
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
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departments(String id, String name, String note) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", note=" + note
				+ "]";
	}
	
	
}
