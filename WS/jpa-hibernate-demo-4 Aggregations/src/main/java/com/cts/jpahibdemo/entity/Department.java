package com.cts.jpahibdemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	@Column(name="dname",nullable = false,unique = true)
	private String title;
	
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	private Set<Employee> emps;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long deptId, String title, Set<Employee> emps) {
		super();
		this.deptId = deptId;
		this.title = title;
		this.emps = emps;
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
	
	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", title=" + title + "]";
	}
	
	
}
