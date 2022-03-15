package com.cts.jpahibdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	@Column(name="dname",nullable = false,unique = true)
	private String title;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long deptId, String title) {
		super();
		this.deptId = deptId;
		this.title = title;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", title=" + title + "]";
	}
	
	
}
